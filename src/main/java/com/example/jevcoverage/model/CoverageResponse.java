package com.example.jevcoverage.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CoverageResponse {
    private List<CoverageResponseItem> recommendedCoverages;
}
