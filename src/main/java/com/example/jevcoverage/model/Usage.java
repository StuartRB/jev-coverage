package com.example.jevcoverage.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Usage(
        @JsonProperty("input_tokens")
        int inputTokens,

        @JsonProperty("output_tokens")
        int outputTokens
) {}
