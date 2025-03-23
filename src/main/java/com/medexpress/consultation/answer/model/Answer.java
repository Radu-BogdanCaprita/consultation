package com.medexpress.consultation.answer.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {
    @NotNull
    private Integer questionId;

    @NotBlank(message = "Answer cannot be blank")
    private String text;
}
