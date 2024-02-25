package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.AnswerCreateDto;
import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.dto.AnswerUpdateDto;
import com.itgirls.psyhelper1.mappers.AnswerMapper;
import com.itgirls.psyhelper1.exception.NotFoundException;
import com.itgirls.psyhelper1.model.Answer;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.AnswerRepository;
import com.itgirls.psyhelper1.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
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
    public AnswerDto createAnswer(AnswerCreateDto answerDto) {
        log.info("Creating new answer: {}", answerDto);
        //Получение пользователя по userId
        Optional<Users> user = usersRepository.findById(answerDto.getUserId());
        if (user.isEmpty()) {
            throw new NoSuchElementException("User not found");
        }
        // Преобразование объекта AnswerCreateDto в объект Answer с помощью AnswerMapper.toEntity()
        Answer answer = answerMapper.toEntity(answerDto);
        if (answer.getAnswerText() == null || answer.getAnswerText().isEmpty()) {
            throw new IllegalArgumentException("Answer text cannot be empty");
        }
        answer.setUserId(user.get());
        answer.setRead(false);
        answer.setAuthorLiked(false);
        answer.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        try {
            Answer savedAnswer = answerRepository.save(answer);
            log.info("Answer created successfully id: {}", savedAnswer.getId());
            return answerMapper.toDto(savedAnswer);
        } catch (Exception e) {
            log.error("Failed to save answer: " + e.getMessage(), e);
            throw new IllegalStateException("Failed to create answer");
        }
    }

    @Override
    public AnswerDto updateAnswer(UUID id, AnswerUpdateDto answerDto) {
        log.info("Updating answer: {}", answerDto);
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isEmpty()) {
            throw new NoSuchElementException("Answer id: " + id + " not found");
        }
        Optional<Users> user = usersRepository.findById(answerDto.getUserId());
        if (user.isEmpty()) {
            throw new NoSuchElementException("User not found");
        }
        Answer answer = optionalAnswer.get();
        if (answer.getAnswerText() == null || answer.getAnswerText().isEmpty()) {
            throw new IllegalArgumentException("Answer text cannot be empty");
        }
        answer.setUserId(user.get());
        answer.setQuestionId(answerDto.getQuestionId());
        answer.setAnswerText(answerDto.getAnswerText());
        answer.setRead(answerDto.getIsRead());
        answer.setUpdatedAt(answerDto.getUpdatedAt());
        try {
            Answer savedAnswer = answerRepository.save(answer);
            log.info("Answer updated successfully id: {}", savedAnswer.getId());
            return answerMapper.toDto(savedAnswer);
        } catch (Exception e) {
            log.error("Failed to update answer: " + e.getMessage(), e);
            throw new IllegalStateException("Failed to update answer");
        }
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

    @Override
    public List<AnswerDto> getAllAnswers() {
        return null;
    }

    @Override
    public List<AnswerDto> getAnswersByUserId(UUID userId) {
        return null;
    }

    @Override
    public List<AnswerDto> getAnswersByQuestionId(UUID questionId) {
        return null;
    }

    @Override
    public AnswerDto getAnswerById(UUID id) {
        return null;
    }
}
