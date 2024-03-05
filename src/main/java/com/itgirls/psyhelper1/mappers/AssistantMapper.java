package com.itgirls.psyhelper1.mappers;

import com.itgirls.psyhelper1.dto.*;
import com.itgirls.psyhelper1.dto.assistantDto.AssistantCreateDto;
import com.itgirls.psyhelper1.dto.assistantDto.AssistantDto;
import com.itgirls.psyhelper1.model.Assistant;
import com.itgirls.psyhelper1.model.Users;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AssistantMapper {
    AssistantMapper INSTANCE = Mappers.getMapper(AssistantMapper.class);

    @Mapping(source = "usersDto", target = "user", ignore = true)
    Assistant toEntity (AssistantCreateDto assistantCreateDto);

    @Mapping(source = "user", target = "usersDto")
    AssistantDto toDto(Assistant assistant);

    default UsersDto toDto(Users users) {
        return UsersMapper.INSTANCE.toDto(users);
    }
}