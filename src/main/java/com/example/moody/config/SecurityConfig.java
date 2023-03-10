package com.example.moody.config;

import com.example.moody.jwt.JwtFilter;
import com.example.moody.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final TokenProvider tokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()// Request에 인증, 인가(권한 있냐?)를 부여하겠다.
                .antMatchers("/join", "/login").permitAll()  // /index /login 은 인가가 필요없다.
                .antMatchers("/user/**").hasAnyRole("USER")// /user  uri는 USER 롤 또는 ADMIN 롤이 있어야 접속가능
                .anyRequest().authenticated() // 그 외에는 인증된 모든 사용자가 URL을 허용하도록 지정합니다.
                .and()
                // addFilterBefore : 지정된 필터 앞에 커스텀 필터를 추가 (UsernamePasswordAuthenticationFilter 보다 먼저 실행된다)
                // JwtFilter 를 등록한다.
                // SecurityContext를 사용하기 때문에 앞단의 필터에서 SecurityContext가 설정되고 난뒤 필터를 둔다.
                .addFilterBefore(new JwtFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
