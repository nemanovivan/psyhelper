package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.mappers.AnswerMapper;
import com.itgirls.psyhelper1.model.Answer;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.AnswerRepository;
import com.itgirls.psyhelper1.repository.UsersRepository;
import com.itgirls.psyhelper1.service.impl.AnswerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AnswerServiceTest {
    @Mock
    AnswerRepository answerRepository;
    @Mock
    UsersRepository usersRepository;

    @Mock
    AnswerMapper answerMapper;
    @InjectMocks
    AnswerServiceImpl answerService;

    @Test
    public void testCreateAnswer() {
        // Создание тестовых данных
        AnswerDto answerDto = new AnswerDto();
        answerDto.setUserId(new Users());
        answerDto.setAnswerText("text");

        Users user = new Users();
        user.setId(answerDto.getUserId().getId());

        Answer answer = new Answer();
        answer.setUserId(user);
        answer.setAnswerText("answerText");
        answer.setCreatedAt(answer.getCreatedAt());

        Answer savedAnswer = new Answer();
        savedAnswer.setId(UUID.randomUUID());

        // Настройка мок объектов
        when(usersRepository.findById(answerDto.getUserId().getId())).thenReturn(Optional.of(user));
        when(answerRepository.save(Mockito.any(Answer.class))).thenReturn(savedAnswer);
        when(answerMapper.toEntity(answerDto)).thenReturn(answer);

        //Вызов метода
        AnswerDto createdAnswer = answerService.createAnswer(answerDto);

        //Проверка результата
        Assertions.assertThat(createdAnswer).isNotNull();
        Assertions.assertThat(createdAnswer.getUserId()).isEqualTo(answerDto.getUserId());
        Assertions.assertThat(createdAnswer.getAnswerText()).isEqualTo(answerDto.getAnswerText());
        Assertions.assertThat(createdAnswer.getId()).isEqualTo(savedAnswer.getId());

        verify(usersRepository).findById(answerDto.getUserId().getId());
        verify(answerRepository).save(answer);
        verify(answerMapper).toDto(savedAnswer);
    }

    @Test
    public void testDeleteAnswer() {
        // Создание тестовых данных
        UUID answerId = UUID.randomUUID();

        // Настройка мок объекта
        when(answerRepository.findById(answerId)).thenReturn(Optional.of(new Answer()));

        // Вызов метода
        answerService.deleteAnswer(answerId);

        // Проверка результата
        verify(answerRepository).findById(answerId);
        verify(answerRepository).deleteById(answerId);
    }
}
