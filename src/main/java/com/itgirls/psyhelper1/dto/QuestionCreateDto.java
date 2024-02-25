package com.itgirls.psyhelper1.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuestionCreateDto {
    private UUID userId;
    private UUID themeId;
    private Boolean isAnonymous;
    private Boolean isJustExpertRespond;
    private String questionText;
    private Timestamp createdAt;
}
