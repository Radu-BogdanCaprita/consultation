package com.medexpress.consultation.eligibility.service;

import com.medexpress.consultation.answer.model.Answer;
import com.medexpress.consultation.answer.service.AnswerService;
import com.medexpress.consultation.eligibility.model.EligibilityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EligibilityService {

    private final AnswerService answerService;

    public EligibilityResponse getEligibilityForCustomer(String customerId) {
        List<Answer> answers = answerService.getAnswersByCustomerId(customerId);
        if(answers.isEmpty()) {
            return new EligibilityResponse(false, String.format("No answer submitted for customer %s", customerId));
        }
        boolean nonEligibleAnswer = answers.stream().anyMatch(answer -> answer.getText().equalsIgnoreCase("yes"));
        if(nonEligibleAnswer) {
            return new EligibilityResponse(false, "User is not eligible.");
        }
        return new EligibilityResponse(true, "User is eligible.");
    }
}
