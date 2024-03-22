package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.QuestionThemeDTO;

import java.util.Optional;
import java.util.UUID;

public interface QuestionThemeService {
    void deleteThemeById(UUID id);
    QuestionThemeDTO saveTheme(QuestionThemeDTO themeDTO);
    Optional<QuestionThemeDTO> findByThemeName(String themeName);
    Optional<QuestionThemeDTO> getInfoById(UUID id);

}
