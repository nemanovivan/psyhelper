package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.AnswerCreateDto;
import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.dto.AnswerUpdateDto;

import java.util.List;
import java.util.UUID;

public interface AnswerService {
    AnswerDto createAnswer(AnswerCreateDto answerCreateDto);
    AnswerDto updateAnswer(UUID id, AnswerUpdateDto answerUpdateDto);
    void deleteAnswer(UUID id);
    List<AnswerDto> getAllAnswers();
    List<AnswerDto> getAnswersByUserId(UUID userId);
    List<AnswerDto> getAnswersByQuestionId(UUID questionId);
    AnswerDto getAnswerById(UUID id);
}
