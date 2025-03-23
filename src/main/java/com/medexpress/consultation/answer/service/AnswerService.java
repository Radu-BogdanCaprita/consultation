package com.medexpress.consultation.answer.service;

import com.medexpress.consultation.answer.model.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final Map<String, Map<Integer, Answer>> answers = new HashMap<>(Map.of(
            "user1", Map.of(1, new Answer(1, "no"), 2, new Answer(2, "yes"),
                    3, new Answer(3, "no")),
            "user2", Map.of(1, new Answer(1, "no"), 2, new Answer(2, "no"),
                    3, new Answer(3, "no"))
    ));

    public void saveAnswers(String customerId, List<Answer> answers) {
        this.answers.put(customerId, answers.stream().collect(Collectors.toMap(Answer::getQuestionId, Function.identity())));
    }

    public List<Answer> getAnswers() {
        return answers.values().stream().flatMap(answer -> answer.values().stream()).toList();
    }

    public List<Answer> getAnswersByCustomerId(String customerId) {
        if(!answers.containsKey(customerId)) {
            return List.of();
        }
        return answers.get(customerId).values().stream().toList();
    }
}
