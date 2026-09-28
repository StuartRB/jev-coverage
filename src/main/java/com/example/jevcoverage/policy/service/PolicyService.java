package com.example.jevcoverage.policy.service;

import com.example.jevcoverage.policy.model.PolicyCoverage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    public List<PolicyCoverage> getPolicyCoverages(String policyNumber) {
        // TODO simulate pull coverage and descriptions

        return List.of(
                new PolicyCoverage("COLL", "Collision", "The insured vehicle was damaged by collision with another vehicle or object."),
                new PolicyCoverage("RENTAL", "Rental", "The insured's vehicle is not safe to drive or has been taken away for estimating / repairs or was stolen."),
                new PolicyCoverage("MEDPAY", "Medical Payments", "Pays medical payments for any insured participant"),
                new PolicyCoverage("BI", "Bodily Injury", "Covers injury costs endured by a third party if the insured was at fault"),
                new PolicyCoverage("PROPERTY", "Property Damage Liability", "The insured may be legally responsible for damage to another person's vehicle or other property"),
                new PolicyCoverage("COMP", "Comprehensive", "The insured vehicle suffered a loss from a non-collision event such as theft, fire, weather, vandalism, falling objects, or damage by an animal that was not a collision"));
    }
}
