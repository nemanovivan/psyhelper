package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.mappers.AnswerMapper;
import com.itgirls.psyhelper1.model.Answer;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.AnswerRepository;
import com.itgirls.psyhelper1.service.impl.AnswerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AnswerServiceTest {
    @Mock
    AnswerRepository answerRepository;

    @Mock
    AnswerMapper answerMapper;
    @InjectMocks
    AnswerServiceImpl answerService;

    UUID id = UUID.randomUUID();
    UUID questionId = UUID.randomUUID();
    ZonedDateTime createdAt = ZonedDateTime.now();
    ZonedDateTime updatedAt = ZonedDateTime.now();
    Users userId = new Users();
    int rating = 5;
    String answerText = "answerText";
    private final Answer answer = new Answer(id, questionId, createdAt, updatedAt, userId, rating, answerText);

    @Test
    public void testDeleteAnswerById() {
        // Устанавка поведения для mock объектов
        when(answerRepository.findById(id)).thenReturn(Optional.of(answer));
        // Вызов метода
        answerService.deleteAnswer(id);
        // Проверка поведения
        verify(answerRepository).deleteById(id);
    }
}
