package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.*;
import java.util.List;
import java.util.UUID;

public interface AssistantService {
    AssistantDto createAssistant(AssistantCreateDto assistantCreateDto);

    AssistantUpdateResponseDto updateAssistant(AssistantUpdateDto assistantUpdateDto);

    void deleteAssistantById(UUID id);

    List<AssistantSearchResponseDto> getAssistantsSortedByRatingDesc();

    AssistantResponseDto getInfoById(UUID id);

    AssistantResponseDto getAssistantByUsername(String username);
}
