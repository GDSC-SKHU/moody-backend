package com.example.moody.DTO;

import com.example.moody.domain.Heatmap;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MemberDTO {
    private String userName;
    private String saying;
    private List<HeatmapDTO> heatmap;
}
