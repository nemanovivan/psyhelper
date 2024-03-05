package com.itgirls.psyhelper1.dto.assistantDto;

import com.itgirls.psyhelper1.dto.UsersDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AssistantCreateDto {
    private UsersDto usersDto;
    private String qualification;
    private boolean isExpert;
    private int experience;
    private ZonedDateTime createdAt;
}
