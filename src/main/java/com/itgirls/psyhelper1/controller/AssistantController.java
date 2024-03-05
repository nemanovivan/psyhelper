package com.itgirls.psyhelper1.controller;

import com.itgirls.psyhelper1.dto.assistantDto.AssistantCreateDto;
import com.itgirls.psyhelper1.dto.assistantDto.AssistantDto;
import com.itgirls.psyhelper1.dto.assistantDto.AssistantUpdateDto;
import com.itgirls.psyhelper1.service.AssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assistant")
public class AssistantController {
    private final AssistantService assistantService;

    @PostMapping("/create")
    AssistantDto createAssistant(@RequestBody AssistantCreateDto assistantCreateDto) {
        return assistantService.createAssistant(assistantCreateDto);
    }

    @PostMapping("/update")
    AssistantDto updateAssistant(@RequestBody AssistantUpdateDto assistantUpdateDto) {
        return assistantService.updateAssistant(assistantUpdateDto);
    }

    @DeleteMapping("/delete/{id}")
    void deleteAssistant(@PathVariable("id") UUID id) {
        assistantService.deleteAssistantById(id);
    }
}
