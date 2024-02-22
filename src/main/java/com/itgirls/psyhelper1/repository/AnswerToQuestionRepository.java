package com.itgirls.psyhelper1.repository;

import com.itgirls.psyhelper1.model.AnswerToQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnswerToQuestionRepository extends JpaRepository<AnswerToQuestion, UUID> {
    Optional<AnswerToQuestion> findByUserId(UUID userId);
    Optional<AnswerToQuestion> findByQuestionId(UUID questionId);
    Optional<AnswerToQuestion> findByUserIdAndQuestionId(UUID userId, UUID questionId);
}
