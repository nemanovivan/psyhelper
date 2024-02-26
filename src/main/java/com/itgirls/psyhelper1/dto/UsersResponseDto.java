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
public class UsersResponseDto {
    private String username;
    private Timestamp dateOfBirth;
    private String city;
    private String aboutUser;
}
