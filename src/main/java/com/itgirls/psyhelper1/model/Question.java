package com.itgirls.psyhelper1.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "question")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users user;

//TODO: заменить на ссылку после реализацции Theme
//    @ManyToOne
//    @JoinColumn(name = "theme_id", nullable = false)
//    private Theme theme;
    @Column(name = "theme_id", nullable = false)
    private UUID themeId;

    @Column(name = "anonymous", nullable = false)
    private Boolean isAnonymous;

    @Column(name = "just_expert_respond", nullable = false)
    private Boolean isJustExpertRespond;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Column(name = "is_closed", nullable = false)
    private Boolean isClosed;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
