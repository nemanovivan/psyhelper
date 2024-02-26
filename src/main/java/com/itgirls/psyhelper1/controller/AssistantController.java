package com.itgirls.psyhelper1.controller;

import com.itgirls.psyhelper1.dto.*;
import com.itgirls.psyhelper1.service.AssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assistant")
public class AssistantController {
    private final AssistantService assistantService;

    @PostMapping("/create")
    AssistantDto createUser(@RequestBody AssistantCreateDto assistantCreateDto) {
        return assistantService.createAssistant(assistantCreateDto);
    }

    @PostMapping("/update")
    AssistantUpdateResponseDto updateAssistant(@RequestBody AssistantUpdateDto assistantUpdateDto) {
        return assistantService.updateAssistant(assistantUpdateDto);
    }

    @DeleteMapping("/delete/{id}")
    void deleteAssistant(@PathVariable("id") UUID id) {
        assistantService.deleteAssistantById(id);
    }

    @GetMapping("/assistants")
    List<AssistantSearchResponseDto> getAssistants() {
        return assistantService.getAssistantsSortedByRatingDesc();
    }

    @GetMapping("/{id}")
    AssistantResponseDto getInfoById(@PathVariable("id") UUID id) {
        return assistantService.getInfoById(id);
    }

    @GetMapping("/{username}")
    AssistantResponseDto getAssistantByUsername(@PathVariable("username") String username) {
        return assistantService.getAssistantByUsername(username);
    }
}
