package com.medexpress.consultation.answer.controller;

import com.medexpress.consultation.answer.model.Answer;
import com.medexpress.consultation.answer.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/{customerId}")
    public ResponseEntity<Void> createAnswers(@PathVariable String customerId, @RequestBody @Valid List<@Valid Answer> answers) {
        answerService.saveAnswers(customerId, answers);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAllAnswers() {
        return ResponseEntity.ok(answerService.getAnswers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Answer>> getAnswersByCustomerId(@PathVariable String customerId) {
        List<Answer> answers = answerService.getAnswersByCustomerId(customerId);
        if(answers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(answers);
    }
}
