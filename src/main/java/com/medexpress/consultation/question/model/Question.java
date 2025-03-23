package com.medexpress.consultation.question.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {
    @NotNull
    private Integer id;

    @NotBlank(message = "Question cannot be blank")
    private String text;
}
