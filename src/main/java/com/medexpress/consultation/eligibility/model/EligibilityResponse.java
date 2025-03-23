package com.medexpress.consultation.eligibility.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EligibilityResponse {
    @NotNull
    private boolean isEligible;

    @NotBlank(message = "Reason cannot be blank")
    private String reason;
}
