package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.mappers.AnswerMapper;
import com.itgirls.psyhelper1.model.Answer;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.AnswerRepository;
import com.itgirls.psyhelper1.repository.UsersRepository;
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
    private final UsersRepository usersRepository;
    private final AnswerMapper answerMapper;

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        log.info("Creating new answer: {}", answerDto);
        //Получение пользователя по userId
        Optional<Users> user = usersRepository.findById(answerDto.getUserId());
        if (user.isEmpty()) {
            throw new NoSuchElementException("User not found");
        }
        // Создать новый объект ответа и задать значения
        Answer answer = answerMapper.toEntity(answerDto);
        answer.setUserId(user.get());
        answer.setRead(false);
        answer.setAuthorLiked(false);
        Answer savedAnswer = answerRepository.save(answer);
        log.info("Answer created successfully id: {}", savedAnswer.getId());
        return answerMapper.toDto(savedAnswer);
    }

    @Override
    public void deleteAnswer(UUID id) {
        log.info("Deleting answer with id: {}", id);
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            answerRepository.deleteById(id);
            log.info("Answer was deleted with id {}", id);
        } else {
            log.info("Can't find answer with id {} ", id);
            throw new NoSuchElementException("Answer not found.");
        }
    }
}
