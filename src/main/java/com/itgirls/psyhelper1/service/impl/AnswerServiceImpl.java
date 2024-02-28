package com.itgirls.psyhelper1.service.impl;

import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.mappers.AnswerMapper;
import com.itgirls.psyhelper1.model.Answer;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.AnswerRepository;
import com.itgirls.psyhelper1.repository.UsersRepository;
import com.itgirls.psyhelper1.service.AnswerService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        // Получение пользователя по userId и выброс исключения, если пользователь не найден
        Users user = usersRepository.findById(answerDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        // Проверка на пустое значение текста ответа
        if (StringUtils.isEmpty(answerDto.getAnswerText())) {
            throw new IllegalArgumentException("Answer text cannot be empty");
        }
        // Обновление полей ответа
        Answer answer = answerMapper.toEntity(answerDto);
        answer.setUserId(user);
        answer.setCreatedAt(answer.getCreatedAt());
        try {
            // Сохранение обновлённого ответа и преобразование в DTO
            Answer savedAnswer = answerRepository.save(answer);
            log.info("Answer created successfully id: {}", savedAnswer.getId());
            return answerMapper.toDto(savedAnswer);
        } catch (Exception e) {
            log.error("Failed to save answer: " + e.getMessage(), e);
            throw new IllegalStateException("Failed to create answer");
        }
    }

    @Override
    public AnswerDto updateAnswer(UUID id, AnswerDto answerDto) {
        log.info("Updating answer: {}", answerDto);
        // Поиск ответа по id и выброс исключения, если ответ не найден
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Answer id: " + id + " not found"));
        // Поиск пользователя по userId и выброс исключения, если пользователь не найден
        Users user = usersRepository.findById(answerDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        // Проверка на пустое значение текста ответа
        if (StringUtils.isEmpty(answer.getAnswerText())) {
            throw new IllegalArgumentException("Answer text cannot be empty");
        }
        // Обновление полей ответа
        answer.setUserId(user);
        answer.setQuestionId(answerDto.getQuestionId());
        answer.setAnswerText(answerDto.getAnswerText());
        answer.setUpdatedAt(answerDto.getUpdatedAt());
        try {
            // Сохранение обновлённого ответа и преобразование в DTO
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
        // Поиск ответа по id и выброс исключения, если ответ не найден
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Answer not found."));
        answerRepository.deleteById(id);
        log.info("Answer was deleted with id {}", id);
    }

    @Override
    public List<AnswerDto> getAllAnswers() {
        log.info("Getting all answers");
        // Получение всех ответов из репозитория
        List<Answer> answers = answerRepository.findAll();
        // Преобразование ответов в DTO
        return answers.stream()
                .map(answerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDto> getAnswersByUserId(UUID userId) {
        log.info("Getting answers by user id: {}", userId);
        // Поиск ответов в репозитории по идентификатору пользователя
        Optional<Answer> answers = answerRepository.findByUserId(userId);
        // Выброс исключения, если ответ не найден
        if (answers.isEmpty()) {
            log.error("Can't find answers with user id {}", userId);
            throw new NoSuchElementException("Answers not found");
        }
        // Преобразование ответов в DTO и возвращение в виде списка
        return answers.stream().map(answerMapper::toDto).toList();
    }

    @Override
    public List<AnswerDto> getAnswersByQuestionId(UUID questionId) {
        log.info("Getting answers by question id: {}", questionId);
        // Поиск ответов в репозитории по идентификатору вопроса
        Optional<Answer> answers = answerRepository.findByQuestionId(questionId);
        // Выброс исключения, если ответ не найден
        if (answers.isEmpty()) {
            log.error("Can't find answers with question id {}", questionId);
            throw new NoSuchElementException("Answers not found");
        }
        // Преобразование ответов в DTO и возвращение в виде списка
        return answers.stream()
                .map(answerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDto getAnswerById(UUID id) {
        log.info("Getting answer: {}", id);
        // Поиск ответов в репозитории по идентификатору вопроса
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Can't find answer with id {} ", id);
                    return new NoSuchElementException("Answer not found");
                });
        log.info("Answer was found: {}", id);
        // Преобразование ответов в DTO
        return answerMapper.toDto(answer);
    }

    @Override
    public int getRating(UUID answerId) {
        log.info("Getting rating for answer: {}", answerId);
        //Поиск ответов в репозитории по идентификатору вопроса
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> {
                    log.error("Can't find answer with id {} ", answerId);
                    return new NoSuchElementException("Answer not found");
                });
        //Подсчёт рейтинга
        int rating = answer.getRating();
        log.info("Answer rating: {}", rating);
        return rating;
    }
}
