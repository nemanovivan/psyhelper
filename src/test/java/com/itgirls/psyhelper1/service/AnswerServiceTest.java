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

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

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
    public void testUpdateAnswer() {
        // Создание тестовых данных
        UUID answerId = UUID.randomUUID();
        AnswerDto answerDto = new AnswerDto();
        answerDto.setUserId(new Users());
        answerDto.setQuestionId(UUID.randomUUID());
        answerDto.setAnswerText("updatedText");
        answerDto.setUpdatedAt(ZonedDateTime.now());

        Users user = new Users();
        user.setId(answerDto.getUserId().getId());

        Answer answer = new Answer();
        answer.setId(answerDto.getUserId().getId());

        Answer savedAnswer = new Answer();
        savedAnswer.setId(answerId);

        // Настройка мок объектов
        when(answerRepository.findById(answerId)).thenReturn(Optional.of(answer));
        when(usersRepository.findById(answerDto.getUserId().getId())).thenReturn(Optional.of(user));
        when(answerRepository.save(Mockito.any(Answer.class))).thenReturn(savedAnswer);
        when(answerMapper.toDto(savedAnswer)).thenReturn(answerDto);

        //Вызов метода
        AnswerDto updatedAnswer = answerService.updateAnswer(answerId, answerDto);

        //Проверка результата
        Assertions.assertThat(updatedAnswer).isNotNull();
        Assertions.assertThat(updatedAnswer.getUserId()).isEqualTo(answerDto.getUserId());
        Assertions.assertThat(updatedAnswer.getQuestionId()).isEqualTo(answerDto.getQuestionId());
        Assertions.assertThat(updatedAnswer.getAnswerText()).isEqualTo(answerDto.getAnswerText());
        Assertions.assertThat(updatedAnswer.getUpdatedAt()).isEqualTo(answerDto.getUpdatedAt());

        verify(answerRepository).findById(answerId);
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

    @Test
    public void testGetAllAnswers() {
        // Создание тестовых данных
        Answer answer1 = new Answer();
        answer1.setId(UUID.randomUUID());

        Answer answer2 = new Answer();
        answer2.setId(UUID.randomUUID());

        Answer answer3 = new Answer();
        answer3.setId(UUID.randomUUID());

        List<Answer> answers = Arrays.asList(answer1, answer2, answer3);

        // Настройка мок объектов
        when(answerRepository.findAll()).thenReturn(answers);
        when(answerMapper.toDto(Mockito.any(Answer.class))).thenReturn(new AnswerDto());

        // Вызов метода
        List<AnswerDto> result = answerService.getAllAnswers();

        // Проверка результата
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).hasSize(3);

        verify(answerRepository).findAll();
        verify(answerMapper, times(3)).toDto(Mockito.any(Answer.class));
    }

    @Test
    public void testGetAnswersByUserId() {
        // Создание тестовых данных
        UUID userId = UUID.randomUUID();
        Answer answer1 = new Answer();
        answer1.setId(UUID.randomUUID());
        answer1.setUserId(new Users());

        Answer answer2 = new Answer();
        answer2.setId(UUID.randomUUID());
        answer2.setUserId(new Users());

        List<Answer> answers = Arrays.asList(answer1, answer2);

        // Настройка мок объектов
        when(answerRepository.findByUserId(userId)).thenReturn(Optional.of((Answer) answers));
        when(answerMapper.toDto(Mockito.any(Answer.class))).thenReturn(new AnswerDto());

        // Вызов метода
        List<AnswerDto> result = answerService.getAnswersByUserId(userId);

        // Проверка результата
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).hasSize(2);

        verify(answerRepository).findByUserId(userId);
        verify(answerMapper, times(2)).toDto(Mockito.any(Answer.class));
    }

    @Test
    public void testGetAnswersByQuestionId() {
        // Создание тестовых данных
        UUID questionId = UUID.randomUUID();
        Answer answer1 = new Answer();
        answer1.setId(UUID.randomUUID());
        answer1.setUserId(new Users());

        Answer answer2 = new Answer();
        answer2.setId(UUID.randomUUID());
        answer2.setUserId(new Users());

        List<Answer> answers = Arrays.asList(answer1, answer2);

        // Настройка мок объектов
        when(answerRepository.findByQuestionId(questionId)).thenReturn(Optional.of((Answer) answers));
        when(answerMapper.toDto(Mockito.any(Answer.class))).thenReturn(new AnswerDto());

        // Вызов метода
        List<AnswerDto> result = answerService.getAnswersByQuestionId(questionId);

        // Проверка результата
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).hasSize(2);

        verify(answerRepository).findByQuestionId(questionId);
        verify(answerMapper, times(2)).toDto(Mockito.any(Answer.class));
    }
}
