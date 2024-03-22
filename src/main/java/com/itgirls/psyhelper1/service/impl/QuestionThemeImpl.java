package com.itgirls.psyhelper1.service.impl;

import com.itgirls.psyhelper1.dto.QuestionThemeDTO;
import com.itgirls.psyhelper1.model.QuestionTheme;
import com.itgirls.psyhelper1.repository.QuestionThemeRepo;
import com.itgirls.psyhelper1.service.QuestionThemeService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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
        questionThemeRepo.deleteById(id);

    }

    @Override
    public QuestionThemeDTO saveTheme(QuestionThemeDTO themeDTO) {
        QuestionTheme theme = convertToEntity(themeDTO);
        QuestionTheme savedTheme = questionThemeRepo.save(theme);
        return convertToDto(savedTheme);

    }

    @Override
    public Optional<QuestionThemeDTO> findByThemeName(String themeName) {
        return questionThemeRepo.findByThemeName(themeName)
                .map(this::convertToDto);
    }

    @Override
    public Optional<QuestionThemeDTO> getInfoById(UUID id) {
        return questionThemeRepo.findById(id)
                .map(this::convertToDto);
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
