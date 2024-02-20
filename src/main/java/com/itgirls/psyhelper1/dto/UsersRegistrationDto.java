package com.itgirls.psyhelper1.dto;

import com.itgirls.psyhelper1.model.UsersRole;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersRegistrationDto {
    private String username;
    private String email;
    private String phone;
    private String password;
    private Timestamp dateOfBirth;
    private String city;
    private String aboutUser;
    private String photoLink;
    private UUID usersRoleId;
}