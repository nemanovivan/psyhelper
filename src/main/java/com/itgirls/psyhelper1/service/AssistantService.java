package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.*;
import com.itgirls.psyhelper1.dto.assistantDto.AssistantCreateDto;
import com.itgirls.psyhelper1.dto.assistantDto.AssistantDto;
import com.itgirls.psyhelper1.dto.assistantDto.AssistantUpdateDto;

import java.util.List;
import java.util.UUID;

public interface AssistantService {
    AssistantDto createAssistant(AssistantCreateDto assistantCreateDto);

    AssistantDto updateAssistant(AssistantUpdateDto assistantUpdateDto);

    void deleteAssistantById(UUID id);
}
