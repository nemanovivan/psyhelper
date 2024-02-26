package com.itgirls.psyhelper1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AssistantCreateDto {
    private UsersIdDto usersIdDto;
    private String qualification;
    private boolean isExpert;
    private Timestamp createdAt;
}
