package com.example.moody.repository;

import com.example.moody.DTO.HeatmapDTO;
import com.example.moody.domain.Heatmap;
import com.example.moody.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeatmapRepository extends JpaRepository<Heatmap, Long> {

    List<Heatmap> findAllByMember(Member member);
}
