package com.itgirls.psyhelper1.mappers;

import com.itgirls.psyhelper1.dto.QuestionCreateDto;
import com.itgirls.psyhelper1.dto.QuestionUpdateDto;
import com.itgirls.psyhelper1.dto.QuestionDto;
import com.itgirls.psyhelper1.model.Question;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "userId", target = "user.id")
    Question toEntity(QuestionCreateDto dto);
    QuestionDto toDto(Question question);
}
