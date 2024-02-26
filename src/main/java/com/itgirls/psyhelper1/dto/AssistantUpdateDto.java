package com.itgirls.psyhelper1.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AssistantUpdateDto {
    private UUID id;
    private String qualification;
    private boolean isExpert;
    private Timestamp updatedAt;
}
