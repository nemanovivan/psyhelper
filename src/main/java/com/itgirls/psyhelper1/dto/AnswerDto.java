package com.itgirls.psyhelper1.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class AnswerDto {
    private UUID id;
    private String answerText;
    private boolean isRead;
    private boolean isAuthorLiked;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UUID userId;
    private UUID questionId;
}
