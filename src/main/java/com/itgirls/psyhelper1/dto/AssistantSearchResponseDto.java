package com.itgirls.psyhelper1.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AssistantSearchResponseDto {
    private UsersSearchResponseDto usersSearchResponseDto;
    private int rating;
    private boolean isExpert;
}
