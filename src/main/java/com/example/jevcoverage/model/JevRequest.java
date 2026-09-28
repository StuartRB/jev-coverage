package com.example.jevcoverage.model;

import java.util.Map;

public record JevRequest(
        String state,
        String model,
        Map<String, JevQuestion> questions
) {}