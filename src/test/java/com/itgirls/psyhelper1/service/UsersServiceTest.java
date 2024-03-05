package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.UsersDto;
import com.itgirls.psyhelper1.dto.UsersRegistrationDto;
import com.itgirls.psyhelper1.mappers.UsersMapper;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.model.UsersRole;
import com.itgirls.psyhelper1.repository.UsersRepository;
import com.itgirls.psyhelper1.service.impl.UsersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsersServiceTest {
    @Mock
    UsersRepository usersRepository;

    @Mock
    UsersMapper usersMapper;

    @InjectMocks
    UsersServiceImpl usersService;

    UUID id = UUID.randomUUID();
    String username = "username";
    String email = "email";
    String phone = "phone";
    String password = "password";
    Timestamp dateOfBirth = new Timestamp(System.currentTimeMillis());
    String city = "city";
    String aboutUser = "aboutUser";
    String photoLink = "photoLink";
    UsersRole usersRole = new UsersRole();
    Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
    private Users user = new Users(id, username, email, phone, password, dateOfBirth, city, aboutUser, photoLink, usersRole, createdAt, updatedAt);


    @Test
    public void deleteUserById(){
        when(usersRepository.findById(id)).thenReturn(Optional.of(user));

        usersService.deleteUserById(id);

        verify(usersRepository).deleteById(id);
    }

    @Test
    public void testFindByUsername() {
        UsersDto userDto1 = new UsersDto();
        userDto1.setPhone("phone");
        userDto1.setEmail("email");

        when(usersRepository.findUserByUsername(username)).thenReturn(Optional.of(user));
        when(usersMapper.toDto(user)).thenReturn(userDto1);

        UsersDto userDto = usersService.findByUsername(username);

        verify(usersRepository).findUserByUsername(username);
        Assertions.assertEquals(userDto.getPhone(), user.getPhone());
        Assertions.assertEquals(userDto.getEmail(), user.getEmail());
    }

    @Test
    public void testGetInfoById(){
        when(usersRepository.findById(id)).thenReturn(Optional.ofNullable(user));

        UsersDto userDto = usersService.getInfoById(id);

        verify(usersRepository).findById(id);
        Assertions.assertEquals(userDto.getId(), user.getId());
        Assertions.assertEquals(userDto.getUsername(), user.getUsername());
    }

    @Test
    public void testCreateUser(){
        UsersRegistrationDto userRegDto = new UsersRegistrationDto();
        userRegDto.setUsername("username");
        userRegDto.setEmail("email");
        UsersDto userDto1 = new UsersDto();
        userDto1.setUsername("username");
        userDto1.setEmail("email");

        when(usersRepository.save(Mockito.any(Users.class))).thenReturn(user);
        when(usersMapper.toEntity(userRegDto)).thenReturn(user);
        when(usersMapper.toDto(user)).thenReturn(userDto1);

        UsersDto userDto = usersService.createUser(userRegDto);

        verify(usersRepository).save(user);
        Assertions.assertEquals(userDto.getUsername(), userRegDto.getUsername());
        Assertions.assertEquals(userDto.getEmail(), userRegDto.getEmail());
    }
}
