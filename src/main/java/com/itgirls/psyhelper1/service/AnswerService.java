package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.AnswerDto;

import java.util.List;
import java.util.UUID;

public interface AnswerService {
    AnswerDto createAnswer(AnswerDto answerDto);
    AnswerDto updateAnswer(AnswerDto answerDto);
    void deleteAnswerById(UUID id);
    List<AnswerDto> getAllAnswers();
    List<AnswerDto> getAnswersByUserId(UUID userId);
    List<AnswerDto> getAnswersByQuestionId(UUID questionId);
    AnswerDto getAnswerById(UUID id);
}
