package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.model.Answer;
import com.itgirls.psyhelper1.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;



    @Override
    public void deleteAnswer(UUID id) {
        log.info("Deleting answer with id: {}", id);
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            Answer answer = optionalAnswer.get();
            answerRepository.delete(answer);
            log.info("Answer with id {} " + id + " was deleted");
        } else {
            log.info("Can't find answer with id {} " + id);
            throw new NoSuchElementException("Answer not found.");
        }
    }
}
