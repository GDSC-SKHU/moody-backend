package com.example.moody.DTO;

import com.example.moody.domain.Member;
import lombok.Data;

import java.util.Collections;

@Data
public class LoginDTO {
    private String userName;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .userName(userName)
                .password(password)
                .roles(Collections.singletonList("USER"))
                .build();
    }
}


