package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.answer.AnswerDto;

import java.util.List;
import java.util.UUID;

public interface AnswerService {
    AnswerDto createAnswer(AnswerDto answerCreateDto);
    AnswerDto updateAnswer(UUID id, AnswerDto answerUpdateDto);
    void deleteAnswer(UUID id);
    List<AnswerDto> getAllAnswers();
    List<AnswerDto> getAnswersByUserId(UUID userId);
    List<AnswerDto> getAnswersByQuestionId(UUID questionId);
    AnswerDto getAnswerById(UUID id);
    int getRating(UUID answerId);
}
