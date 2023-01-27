package com.example.moody.domain;

import com.example.moody.DTO.HeatmapDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "heatmap")
@Entity
public class Heatmap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false, length = 150)
    private String date;

    @Column(name = "feeling", nullable = false)
    private Long feeling;

    @ManyToOne(targetEntity = Member.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    public HeatmapDTO toDTO(){
        return HeatmapDTO.builder()
                .date(date)
                .feeling(feeling)
                .build();
    }
}
