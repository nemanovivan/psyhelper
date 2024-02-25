package com.itgirls.psyhelper1.dto;

import com.itgirls.psyhelper1.model.Users;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuestionDto {
    private UUID id;
    private Users user;
    private UUID themeId;
    private Boolean isAnonymous;
    private Boolean isJustExpertRespond;
    private String questionText;
    private Boolean isClosed;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
