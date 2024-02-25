package com.itgirls.psyhelper1.mappers;

import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(source = "userId", target = "user.id")
    Answer toEntity(AnswerDto answerDto);
    AnswerDto toDto(Answer answer);
}
