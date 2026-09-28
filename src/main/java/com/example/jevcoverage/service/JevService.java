package com.example.jevcoverage.service;

import com.example.jevcoverage.client.JevClient;
import com.example.jevcoverage.model.*;
import com.example.jevcoverage.policy.model.PolicyCoverage;
import com.example.jevcoverage.policy.service.PolicyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JevService {

    private PolicyService policyService;
    private JevClient jevClient;
    private final Double THRESHOLD = 0.5;

    public List<CoverageResponseItem> getCoverageDetermination(CoverageRequest coverageRequest) {
        var policyCoverages = policyService.getPolicyCoverages(coverageRequest.getPolicyNumber());

        Map<String, JevQuestion> questions = policyCoverages.stream()
                .collect(Collectors.toMap(
                        PolicyCoverage::code,
                        this::toJevQuestion
                ));

        JevRequest request = new JevRequest(
                coverageRequest.getLossDescription(),
                "jev-latest",
                questions
        );

        var decision = jevClient.getCoverageDecision(request);

        List<CoverageResponseItem> recommendedCoverages = new ArrayList<>();

        for (Map.Entry<String, JevAnswer> entry : decision.answers().entrySet()) {

            String coverage = entry.getKey();
            JevAnswer answer = entry.getValue();

            System.out.println(
                    coverage + " = " + answer.noul()
            );
            if (answer.noul() > THRESHOLD) {
                recommendedCoverages.add(new CoverageResponseItem(coverage, answer.noul()));
            }
        }

        return recommendedCoverages;
    }

    private JevQuestion toJevQuestion(PolicyCoverage coverage) {

        return new JevQuestion(
                "noul",
                "Based on the loss facts, should "
                        + coverage.name()
                        + " coverage potentially be opened?",
                new Criteria(
                        coverage.definition(),
                        "There is no evidence that the loss meets "
                                + coverage.name()
                                + " coverage criteria."
                )
        );
    }
}
