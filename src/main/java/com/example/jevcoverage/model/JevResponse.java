package com.example.jevcoverage.model;

import java.util.Map;

public record JevResponse(
        String model,
        Map<String, JevAnswer> answers,
        Usage usage
) {}
