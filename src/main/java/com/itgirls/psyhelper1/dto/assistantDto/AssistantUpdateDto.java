package com.itgirls.psyhelper1.dto.assistantDto;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AssistantUpdateDto {
    private UUID id;
    private String qualification;
    private boolean isExpert;
    private ZonedDateTime updatedAt;
}
