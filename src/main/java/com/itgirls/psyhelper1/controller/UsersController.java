package com.itgirls.psyhelper1.controller;

import com.itgirls.psyhelper1.dto.UsersDto;
import com.itgirls.psyhelper1.dto.UsersRegistrationDto;
import com.itgirls.psyhelper1.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsersController {
    private final UsersService usersService;

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable("id") UUID id) {
        usersService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    UsersDto getInfoById(@PathVariable("id") UUID id) {
        return usersService.getInfoById(id);
    }

    @GetMapping("/{username}")
    UsersDto getUserByUsername(@PathVariable("username") String username) {
        return usersService.findByUsername(username);
    }

    @GetMapping("/users")
    List<UsersDto> getUsersByUsernameAndAssistantRating(@RequestParam String username, @RequestParam int rating) {
        return usersService.findUsersByUsernameAndAssistantRating(username, rating);
    }

    @PostMapping("/registration")
    UsersDto createUser(@RequestBody UsersRegistrationDto user) {
        return usersService.createUser(user);
    }
}
