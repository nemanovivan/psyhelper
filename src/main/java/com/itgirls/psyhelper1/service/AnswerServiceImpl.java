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

    public AnswerDto

    @Override
    public void deleteAnswerById(UUID id) {
        Optional<Answer> answer = answerRepository.findById(id);
        if(answer.isPresent()) {
            answerRepository.deleteById(id);
            log.info("Answer with id {} " + id + " was deleted");
        } else {
            log.info("Can't find answer with id {} " + id);
            throw new NoSuchElementException("No value present");
        }
    }
}
