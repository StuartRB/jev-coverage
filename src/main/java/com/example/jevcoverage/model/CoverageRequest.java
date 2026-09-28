package com.example.jevcoverage.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoverageRequest {
    private String lossDescription;
    private String policyNumber;
}
