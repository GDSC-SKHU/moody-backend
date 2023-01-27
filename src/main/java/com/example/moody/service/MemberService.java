package com.example.moody.service;

import com.example.moody.DTO.HeatmapDTO;
import com.example.moody.DTO.LoginDTO;
import com.example.moody.DTO.MemberDTO;
import com.example.moody.DTO.TokenDTO;
import com.example.moody.domain.Heatmap;
import com.example.moody.domain.Member;
import com.example.moody.domain.Quote;
import com.example.moody.jwt.TokenProvider;
import com.example.moody.repository.HeatmapRepository;
import com.example.moody.repository.MemberRepository;
import com.example.moody.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final HeatmapRepository heatmapRepository;
    private final QuoteRepository quoteRepository;

    @Transactional
    public TokenDTO login(String memberId, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDTO tokenDTO = tokenProvider.createToken(authentication);

        return tokenDTO;
    }

    @Transactional
    public void join(LoginDTO loginDTO) {
        if(memberRepository.findByUserName(loginDTO.getUserName()).isPresent()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }

        loginDTO.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        memberRepository.save(loginDTO.toEntity());
    }


    @Transactional
    public MemberDTO findAllByMember(Principal principal, String userName) {
        if(!userName.equals(principal.getName()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,userName+"의 정보를 불러 올 수 있습니다.");

        Member member = memberRepository.findByUserName(userName)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 사용자를 찾을 수 없습니다."));
        List<HeatmapDTO> heatmaps =
                heatmapRepository.findAllByMember(member).stream()
                .map(Heatmap::toDTO)
                .collect(Collectors.toList());
        List<Quote> quotes = quoteRepository.findAll();
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());


        return MemberDTO.builder()
                .userName(userName)
                .heatmap(heatmaps)
                .saying(quotes.get(randomIndex).getSaying())
                .build();
    }
}
