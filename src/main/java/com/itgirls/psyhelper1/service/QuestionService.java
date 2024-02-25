package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.QuestionCreateDto;
import com.itgirls.psyhelper1.dto.QuestionDto;
import com.itgirls.psyhelper1.dto.QuestionUpdateDto;

import java.util.List;
import java.util.UUID;

public interface QuestionService {
    QuestionDto createQuestion(QuestionCreateDto dto);
    QuestionDto updateQuestion(UUID id, QuestionUpdateDto dto);
    void deleteQuestion(UUID id);
    QuestionDto getQuestionById(UUID id);
    List<QuestionDto> getAllQuestions();
}
