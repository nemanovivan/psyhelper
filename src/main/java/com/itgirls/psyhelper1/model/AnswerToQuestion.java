package com.itgirls.psyhelper1.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "answer_to_question")
public class AnswerToQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "answer_text", nullable = false)
    private String answerText;

    @Column(name = "is_read", nullable = false)
    private boolean isRead;

    @Column(name = "is_author_liked")
    private boolean isAuthorLiked;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UUID userId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private UUID questionId;
}
