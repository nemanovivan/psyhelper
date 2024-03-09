package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.QuestionThemeDTO;
import com.itgirls.psyhelper1.model.QuestionTheme;
import com.itgirls.psyhelper1.repository.QuestionThemeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.web.servlet.support.RequestContextUtils.getTheme;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionThemeRepoImpl implements QuestionThemeService {
    private final QuestionThemeRepository questionThemeRepository;

    @Override
    public QuestionThemeDTO getByName(String theme_name) {
        QuestionTheme questionTheme = questionThemeRepository.findByName(theme_name)
                .orElseThrow(() -> new EntityNotFoundException("(\"QuestionTheme not found with name: \" + themeName"));
            return new QuestionThemeDTO(questionTheme.getId(), questionTheme.getTheme_name());
        }
    }

