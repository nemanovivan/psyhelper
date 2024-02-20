package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.UsersDto;
import com.itgirls.psyhelper1.dto.UsersRegistrationDto;
import com.itgirls.psyhelper1.mappers.UsersMapper;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersServiceImpl implements UsersService{
    private final UsersRepository repository;
    private final UsersMapper usersMapper;


    @Override
    public void deleteUserById(UUID id) {
        Optional<Users> user = repository.findById(id);
        if(user.isPresent()) {
            repository.deleteById(id);
            log.info("User with id {}" +id + "was deleted");
        }
        else{
            log.info("Can't find user with id {}" + id);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public void save(Users user) {
        repository.save(user);
        log.info("New user was successfully saved");
    }

    @Override
    public UsersDto createUser(UsersRegistrationDto usersRegistrationDto) {
        Users user = usersMapper.toEntity(usersRegistrationDto);
        log.info("Add new user with data: {}", usersRegistrationDto.toString());
        Users savedUser = repository.save(user);
        log.info("User successfully saved");
        return usersMapper.toDto(savedUser);
    }

    @Override
    public UsersDto findByUsername(String username) {
        log.info("Trying to find user with username: {}" + username);
        Users user = repository.findUserByUsername(username).get();
        return usersMapper.toDto(user);
    }

    @Override
    public UsersDto getInfoById(UUID id) {
        Optional<Users> user = repository.findById(id);
        UsersDto userDto = null;
        if(user.isPresent()){
            log.info("User with id {}" +id + "was found: {}", user);
            return userDto = usersMapper.toDto(user.get());
        }
        else{
            log.info("Can't find user with id {}" + id);
            throw new NoSuchElementException("No value present");
        }
    }
}