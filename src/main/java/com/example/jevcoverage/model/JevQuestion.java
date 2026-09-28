package com.example.jevcoverage.model;

public record JevQuestion(
        String type,
        String instructions,
        Criteria criteria
) {}
