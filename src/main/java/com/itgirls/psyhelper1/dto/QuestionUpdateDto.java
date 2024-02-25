package com.itgirls.psyhelper1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuestionUpdateDto {
    private UUID userId; //можно ли менять?
    private UUID themeId;
    private Boolean isAnonymous;
    private Boolean isJustExpertRespond;
    private String questionText;
    private Boolean isClosed;
    private Timestamp updatedAt;
}
