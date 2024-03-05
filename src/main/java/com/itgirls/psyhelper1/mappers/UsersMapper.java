package com.itgirls.psyhelper1.mappers;

import com.itgirls.psyhelper1.dto.UsersDto;
import com.itgirls.psyhelper1.dto.UsersRegistrationDto;
import com.itgirls.psyhelper1.dto.assistantDto.AssistantDto;
import com.itgirls.psyhelper1.model.Assistant;
import com.itgirls.psyhelper1.model.Users;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    @Mapping(source = "usersRole.id", target = "usersRoleId")
    @Mapping(source = "getNumberOfAnswers", target = "numberOfAnswers")
    UsersDto toDto (Users users);

    Users toEntity(UsersDto usersDto);

    @Mapping(source = "usersRoleId", target = "usersRole.id")
    Users toEntity(UsersRegistrationDto usersRegistrationDto);

    default AssistantDto toDto(Assistant assistant) {
        return AssistantMapper.INSTANCE.toDto(assistant);
    }
}
