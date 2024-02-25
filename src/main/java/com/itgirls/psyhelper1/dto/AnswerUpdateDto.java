package com.itgirls.psyhelper1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnswerUpdateDto {
    private UUID userId;
    private UUID questionId;
    private String answerText;
    private boolean isRead;
    private boolean isAuthorLiked;
    private Timestamp updatedAt;
}
