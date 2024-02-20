package com.itgirls.psyhelper1.mappers;

import com.itgirls.psyhelper1.dto.UsersDto;
import com.itgirls.psyhelper1.dto.UsersRegistrationDto;
import com.itgirls.psyhelper1.model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsersMapperTest {

    @Test
    public void mapperToDto(){
        Users user = new Users();
        user.setUsername("username");
        user.setEmail("email");

        UsersDto usersDto = UsersMapper.INSTANCE.toDto(user);

        Assertions.assertNotNull(usersDto);
        Assertions.assertEquals("username",usersDto.getUsername());
        Assertions.assertEquals("email", usersDto.getEmail());
    }

    @Test
    public void mapperToEntity(){
        UsersDto userDto = new UsersDto();
        userDto.setUsername("username");
        userDto.setEmail("email");

        Users user = UsersMapper.INSTANCE.toEntity(userDto);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("username",user.getUsername());
        Assertions.assertEquals("email", user.getEmail());
    }

    @Test
    public void mapperToEntityReg(){
        UsersRegistrationDto userDto = new UsersRegistrationDto();
        userDto.setUsername("username");
        userDto.setEmail("email");

        Users user = UsersMapper.INSTANCE.toEntity(userDto);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("username",user.getUsername());
        Assertions.assertEquals("email", user.getEmail());
    }
}
