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
    private String answerText;
    private Boolean isRead;
    private Boolean isAuthorLiked;
    private Timestamp updatedAt;
    private UUID userId;
    private UUID questionId;
}
