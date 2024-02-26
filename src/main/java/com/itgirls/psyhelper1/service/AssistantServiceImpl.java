package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.*;
import com.itgirls.psyhelper1.mappers.AssistantMapper;
import com.itgirls.psyhelper1.model.Assistant;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.AssistantRepository;
import com.itgirls.psyhelper1.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssistantServiceImpl implements AssistantService{
    private AssistantRepository assistantRepository;
    private UsersRepository usersRepository;
    private AssistantMapper assistantMapper;

    @Override
    public AssistantDto createAssistant(AssistantCreateDto assistantCreateDto) {
        UUID usersId = assistantCreateDto.getUsersIdDto().getId();
        Optional<Users> usersOptional = usersRepository.findById(usersId);
        Users user = null;
        if (usersOptional.isPresent()) {
            user = usersOptional.get();
        }
        Assistant assistant = assistantMapper.toEntity(assistantCreateDto);
        assistant.setUser(user);
        log.info("Add new assistant with data: {}", assistantCreateDto.toString());
        assistantRepository.save(assistant);
        log.info("Assistant successfully saved");
        return assistantMapper.toDto(assistant);
    }

    @Override
    public AssistantUpdateResponseDto updateAssistant(AssistantUpdateDto assistantUpdateDto) {
        UUID assistantId = assistantUpdateDto.getId();
        Optional<Assistant> assistantOptional = assistantRepository.findById(assistantId);
        Assistant assistant = null;
        if (assistantOptional.isPresent()) {
            assistant = assistantOptional.get();
            log.info("Update assistant with id: {}", assistantId);
            assistant.setQualification(assistant.getQualification());
            assistant.setExpert(assistantUpdateDto.isExpert());
            assistant.setUpdatedAt(assistantUpdateDto.getUpdatedAt());
            log.info("Assistant successfully updated");
            return assistantMapper.toUpdateResponseDto(assistant);
        } else {
            log.info("Can't find assistant with id {}" + assistantId);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public void deleteAssistantById(UUID id) {
        Optional<Assistant> assistantOptional = assistantRepository.findById(id);
        if (assistantOptional.isPresent()) {
            assistantRepository.deleteById(id);
            log.info("Assistant with id {}" + id + "was deleted");
        } else {
            log.info("Can't find assistant with id {}" + id);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public List<AssistantSearchResponseDto> getAssistantsSortedByRatingDesc() {
        log.info("Get sorted descending list of assistants by rating");
        log.info("Sorted descending list of assistants received");
        return assistantRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Assistant::getRating).reversed())
                .map(assistant -> assistantMapper.toSearchResponseDto(assistant))
                .collect(Collectors.toList());
    }

    @Override
    public AssistantResponseDto getInfoById(UUID id) {
        Optional<Assistant> assistantOptional = assistantRepository.findById(id);
        if(assistantOptional.isPresent()){
            log.info("Assistant with id {}" +id + "was found: {}", assistantOptional.get());
            return assistantMapper.toResponseDto(assistantOptional.get());
        }
        else{
            log.info("Can't find assistant with id {}" + id);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public AssistantResponseDto getAssistantByUsername(String username) {
        Optional<Users> usersOptional = usersRepository.findUserByUsername(username);
        if (usersOptional.isPresent()) {
            Users user = usersOptional.get();
            Optional<Assistant> assistantOptional = assistantRepository.findAssistantByUsers(user);
            if (assistantOptional.isPresent()) {
                return assistantMapper.toResponseDto(assistantOptional.get());
            } else {
                log.info("Can't find assistant with username {}" + username);
                throw new NoSuchElementException("No value present");
            }
        } else {
            log.info("Can't find user with username {}" + username);
            throw new NoSuchElementException("No value present");
        }
    }
}
