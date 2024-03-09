package com.itgirls.psyhelper1.service;

import com.itgirls.psyhelper1.dto.QuestionThemeDTO;
import com.itgirls.psyhelper1.model.QuestionTheme;
import com.itgirls.psyhelper1.repository.QuestionThemeRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public interface QuestionThemeService {

    QuestionThemeDTO getByName(String theme_name);
    }
