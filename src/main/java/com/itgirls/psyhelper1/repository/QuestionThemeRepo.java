package com.itgirls.psyhelper1.repository;

import com.itgirls.psyhelper1.model.QuestionTheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionThemeRepo extends JpaRepository<QuestionTheme, UUID> {
    Optional<QuestionTheme> findByThemeName(String themeName);
}
