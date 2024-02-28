package com.itgirls.psyhelper1.mappers;

//import com.itgirls.psyhelper1.dto.AnswerCreateDto;
import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(source = "userId", target = "userId.id")
    Answer toEntity(AnswerDto answerDto);

    @Mapping(source = "userId.id", target = "userId")
    AnswerDto toDto(Answer answer);
}
