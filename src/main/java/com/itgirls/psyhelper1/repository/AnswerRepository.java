package com.itgirls.psyhelper1.repository;

import com.itgirls.psyhelper1.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    Optional<Answer> findByUserId(UUID userId);
    Optional<Answer> findByQuestionId(UUID questionId);
    Optional<Answer> findByUserIdAndQuestionId(UUID userId, UUID questionId);
}
