package com.medexpress.consultation.eligibility.controller;

import com.medexpress.consultation.eligibility.model.EligibilityResponse;
import com.medexpress.consultation.eligibility.service.EligibilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eligibility")
public class EligibilityController {

    private final EligibilityService eligibilityService;

    @GetMapping("/{customerId}")
    public ResponseEntity<EligibilityResponse> getEligibilityForCustomer(@PathVariable String customerId) {
        return ResponseEntity.ok(eligibilityService.getEligibilityForCustomer(customerId));
    }
}
