package com.itgirls.psyhelper1.dto;

import com.itgirls.psyhelper1.model.UsersRole;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class UsersDto {
    private UUID id;
    private String username;
    private String email;
    private String phone;
    private Timestamp dateOfBirth;
    private String city;
    private String aboutUser;
    private String photoLink;
    private UUID usersRoleId;
}