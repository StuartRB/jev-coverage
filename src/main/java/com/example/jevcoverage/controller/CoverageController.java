package com.example.jevcoverage.controller;

import com.example.jevcoverage.model.CoverageRequest;
import com.example.jevcoverage.model.CoverageResponseItem;
import com.example.jevcoverage.service.JevService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CoverageController {

    private JevService jevService;

    @PostMapping("api/v1/coverages")
    public List<CoverageResponseItem> getCoverageDetermination(@RequestBody CoverageRequest coverageRequest) {
        return jevService.getCoverageDetermination(coverageRequest);
    }
}
