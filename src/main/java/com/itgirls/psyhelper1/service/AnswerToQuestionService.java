package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.AnswerToQuestionDto;
import com.itgirls.psyhelper1.model.AnswerToQuestion;

import java.util.List;
import java.util.UUID;

public interface AnswerToQuestionService {
    AnswerToQuestionDto createAnswer(AnswerToQuestionDto answerDto);
    AnswerToQuestionDto saveAnswer(AnswerToQuestionDto answer);
    AnswerToQuestionDto updateAnswer(AnswerToQuestionDto answerDto);
    void deleteAnswerById(UUID id);
    List<AnswerToQuestionDto> getAllAnswers();
    List<AnswerToQuestionDto> getAnswersByUserId(UUID userId);
    List<AnswerToQuestionDto> getAnswersByQuestionId(UUID questionId);
    AnswerToQuestionDto getAnswerById(UUID id);
}
