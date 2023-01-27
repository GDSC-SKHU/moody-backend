package com.example.moody.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeatmapDTO {
    private String date;
    private Long feeling;
}
