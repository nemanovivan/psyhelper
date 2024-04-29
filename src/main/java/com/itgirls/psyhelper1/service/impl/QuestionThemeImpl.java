package com.itgirls.psyhelper1.service.impl;

import com.itgirls.psyhelper1.dto.QuestionThemeDTO;
import com.itgirls.psyhelper1.model.QuestionTheme;
import com.itgirls.psyhelper1.repository.QuestionThemeRepo;
import com.itgirls.psyhelper1.service.QuestionThemeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionThemeImpl implements QuestionThemeService {
    private final QuestionThemeRepo questionThemeRepo;


    @Override
    public void deleteThemeById(UUID id) {
        log.info("Deleting question theme with id {}", id);
        questionThemeRepo.deleteById(id);
        log.info("Question theme with id {} deleted successfully", id);

    }

    @Override
    public QuestionThemeDTO saveTheme(QuestionThemeDTO themeDTO) {
        log.info("Saving new question theme: {}", themeDTO);
        QuestionTheme theme = convertToEntity(themeDTO);
        QuestionTheme savedTheme = questionThemeRepo.save(theme);
        log.info("Question theme saved successfully with id {}", savedTheme.getId());
        return convertToDto(savedTheme);


    }

    @Override
    public Optional<QuestionThemeDTO> findByThemeName(String themeName) {
        log.info("Searching for question themes with name '{}'", themeName);
        return questionThemeRepo.findByThemeName(themeName).map(this::convertToDto);
    }

    @Override
    public Optional<QuestionThemeDTO> getInfoById(UUID id) {
        log.info("Try to find Question Themes by id {}", id);
        Optional<QuestionTheme> questionThemeOptional = questionThemeRepo.findById(id);

        if (questionThemeOptional.isPresent()) {
            QuestionThemeDTO questionThemeDTO = convertToDto(questionThemeOptional.get());
            log.info("Question_Themes: {}", questionThemeDTO);
            return Optional.of(questionThemeDTO);
        } else {
            log.error("Question_Themes id {} not found", id);
            throw new CustomNotFoundException("Question_Themes id " + id + " not found");
        }
    }

    private QuestionTheme convertToEntity(QuestionThemeDTO themeDTO) {
        QuestionTheme theme = new QuestionTheme();
        theme.setId(themeDTO.getId());
        theme.setThemeName(themeDTO.getThemeName());
        return theme;
    }

    private QuestionThemeDTO convertToDto(QuestionTheme questionTheme) {
        QuestionThemeDTO dto = new QuestionThemeDTO();
        dto.setId(questionTheme.getId());
        dto.setThemeName(questionTheme.getThemeName());
        return dto;
    }
}
