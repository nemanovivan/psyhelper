package com.itgirls.psyhelper1.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder
@Setter
public class QuestionThemeDTO {

    private UUID id;
    private String themeName;
}
