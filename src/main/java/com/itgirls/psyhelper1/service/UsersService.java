package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.UsersDto;
import com.itgirls.psyhelper1.dto.UsersRegistrationDto;
import com.itgirls.psyhelper1.model.Users;

import java.util.Optional;
import java.util.UUID;

public interface UsersService {
    void deleteUserById(UUID id);
    void save(Users user);
    UsersDto createUser(UsersRegistrationDto usersRegistrationDto);

    UsersDto findByUsername(String userName);
    UsersDto getInfoById(UUID id);
}