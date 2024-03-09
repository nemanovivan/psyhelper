package com.itgirls.psyhelper1.repository;

import com.itgirls.psyhelper1.model.QuestionTheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QuestionThemeRepository extends JpaRepository<QuestionTheme, UUID> {
    Optional<QuestionTheme> findByName(String name);

}
