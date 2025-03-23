package com.medexpress.consultation.question.service;

import com.medexpress.consultation.question.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final Map<Integer, Question> questions = new HashMap<>(
            Map.of(
                    1, new Question(1, "Do you have any known allergies to pear-based products?"),
                    2, new Question(2, "Have you ever experienced an adverse reaction to the medication we may prescribe?"),
                    3, new Question(3, "Are you currently taking any other medication?")
            )
    );

    public List<Question> getAllQuestions() {
        return questions.values().stream().toList();
    }

    public void addQuestion(Question question) {
        questions.put(question.getId(), question);
    }
}
