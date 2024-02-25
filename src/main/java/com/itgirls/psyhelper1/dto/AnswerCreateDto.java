package com.itgirls.psyhelper1.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnswerCreateDto {
    private UUID userId;
    private UUID questionId;
    private String answerText;
    private boolean isAuthorLiked;
    private Timestamp createdAt;
}
