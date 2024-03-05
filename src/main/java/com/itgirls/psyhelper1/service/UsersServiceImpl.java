package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.UsersDto;
import com.itgirls.psyhelper1.dto.UsersRegistrationDto;
import com.itgirls.psyhelper1.mappers.UsersMapper;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

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
            log.info("User with id {} was deleted", id);
        }
        else{
            log.info("Can't find user with id {}", id);
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
        log.info("Trying to find user with username: {}", username);
        Users user = repository.findUserByUsername(username).get();
        return usersMapper.toDto(user);
    }

    @Override
    public UsersDto getInfoById(UUID id) {
        Optional<Users> user = repository.findById(id);
        UsersDto userDto = null;
        if(user.isPresent()){
            log.info("User with id {} was found: {}", id, user);
            return userDto = usersMapper.toDto(user.get());
        }
        else{
            log.info("Can't find user with id {}", id);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public List<UsersDto> findUsersByUsernameAndAssistantRating(String username, int rating) {
        List<UsersDto> usersList = null;
        if (username == null) {
            log.info("All Users with rating greater than {}", rating);
            usersList = repository.findAll()
                    .stream()
                    .filter(users -> users.getAssistant().getRating() > rating)
                    .map(users -> usersMapper.toDto(users)).toList();
        } else {
            log.info("All Users with username {} and rating greater than {}", username, rating);
            usersList = repository.findUserByUsername(username)
                    .stream()
                    .filter(users -> users.getAssistant().getRating() > rating)
                    .map(users -> usersMapper.toDto(users)).toList();

        }
        return usersList;
    }
}