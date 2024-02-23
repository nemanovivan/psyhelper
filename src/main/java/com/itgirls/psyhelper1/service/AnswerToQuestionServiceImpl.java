package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.model.AnswerToQuestion;
import com.itgirls.psyhelper1.repository.AnswerToQuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnswerToQuestionServiceImpl implements AnswerToQuestionService{
    private final AnswerToQuestionRepository answerRepository;

    @Override
    public void deleteAnswerById(UUID id) {
        Optional<AnswerToQuestion> answer = answerRepository.findById(id);
        if(answer.isPresent()) {
            answerRepository.deleteById(id);
            log.info("Answer with id {} " + id + " was deleted");
        } else {
            log.info("Can't find answer with id {} " + id);
            throw new NoSuchElementException("No value present");
        }
    }
}
