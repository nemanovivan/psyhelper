package com.itgirls.psyhelper1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AssistantResponseDto {
    private UsersResponseDto usersResponseDto;
    private boolean isExpert;
    private int rating;
}
