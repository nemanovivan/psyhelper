package com.itgirls.psyhelper1.mappers;

//import com.itgirls.psyhelper1.dto.AnswerCreateDto;
import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.model.Answer;
import com.itgirls.psyhelper1.model.Users;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(source = "userId", target = "userId.id")
    Answer toEntity(AnswerDto answerDto);

    @Mapping(source = "userId.id", target = "userId")
    AnswerDto toDto(Answer answer);

    default Users map(UUID value) {
        Users user = new Users();
        user.setId(value);
        return user;
    }

    default UUID map(Users value) {
        return value.getId();
    }
}
