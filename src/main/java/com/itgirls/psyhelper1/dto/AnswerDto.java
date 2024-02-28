package com.itgirls.psyhelper1.dto;

import lombok.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class AnswerDto {
    private UUID id;
    private UUID questionId;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private UUID userId;
    private int rating;
    private String answerText;
}
