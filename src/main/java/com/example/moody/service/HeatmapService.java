package com.example.moody.service;

import com.example.moody.DTO.HeatmapDTO;
import com.example.moody.domain.Heatmap;
import com.example.moody.domain.Member;
import com.example.moody.repository.HeatmapRepository;
import com.example.moody.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HeatmapService {
    private final MemberRepository memberRepository;
    private final HeatmapRepository heatmapRepository;

    @Transactional
    public void saveHeatmap(Principal principal, String userName, HeatmapDTO heatmapDTO) {
        if(!userName.equals(principal.getName()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,userName+"자신만이 정보를 불러 올 수 있습니다.");
        Member member = memberRepository.findByUserName(userName)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 사용자를 찾을 수 없습니다."));;
        heatmapRepository.save(
                Heatmap.builder()
                        .date(heatmapDTO.getDate())
                        .feeling(heatmapDTO.getFeeling())
                        .member(member)
                        .build()
        );
    }



}
