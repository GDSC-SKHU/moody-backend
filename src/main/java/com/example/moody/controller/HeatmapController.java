package com.example.moody.controller;

import com.example.moody.DTO.HeatmapDTO;
import com.example.moody.DTO.MemberDTO;
import com.example.moody.repository.HeatmapRepository;
import com.example.moody.service.HeatmapService;
import com.example.moody.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class HeatmapController {
    private final HeatmapService heatmapService;
    private final MemberService memberService;



    @GetMapping("")
    public ResponseEntity<MemberDTO> findByUserData(
            Principal principal
    ){
        MemberDTO memberDTO = memberService.findAllByMember(principal);
        return ResponseEntity.ok(memberDTO);
    }



    @PostMapping("/add")
    public ResponseEntity<String> postSave(
            Principal principal,
            @RequestBody HeatmapDTO request
    ) {
        heatmapService.saveHeatmap(principal, request);
        return ResponseEntity.ok("heatmap save success");
    }

}
