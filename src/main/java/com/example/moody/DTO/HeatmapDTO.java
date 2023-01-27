package com.example.moody.DTO;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class HeatmapDTO {
    private String year;
    private String month;
    private String day;
    private Long feeling;
}
