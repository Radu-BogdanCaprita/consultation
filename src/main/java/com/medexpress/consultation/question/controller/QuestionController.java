package com.medexpress.consultation.question.controller;

import com.medexpress.consultation.question.model.Question;
import com.medexpress.consultation.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    private ResponseEntity<List<Question>> getQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody @Valid Question question) {
        questionService.addQuestion(question);
        return ResponseEntity.noContent().build();
    }
}
