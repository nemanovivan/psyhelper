package com.itgirls.psyhelper1.dto;

import com.itgirls.psyhelper1.model.Users;
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
    private Users userId;
    private int rating;
    private String answerText;
}
