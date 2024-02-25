package com.itgirls.psyhelper1.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnswerCreateDto {
    private String answerText;
    private Boolean isAuthorLiked;
    private Timestamp createdAt;
    private UUID userId;
    private UUID questionId;
}
