package com.example.moody.controller;

import com.example.moody.DTO.LoginDTO;
import com.example.moody.DTO.MemberDTO;
import com.example.moody.DTO.TokenDTO;
import com.example.moody.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@RequiredArgsConstructor
public class memberController {
    private final MemberService memberService;

    // /login 페이지 이동
    @PostMapping("/login")
    public TokenDTO login(@RequestBody LoginDTO loginDTO) {
        String userName = loginDTO.getUserName();
        String password = loginDTO.getPassword();
        TokenDTO tokenDTO = memberService.login(userName, password);
        return tokenDTO;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody LoginDTO loginDTO) {
        System.out.println("Tsetsetse");
        memberService.join(loginDTO);
        return ResponseEntity.ok("회원가입 성공");
    }


}
