package com.itgirls.psyhelper1.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
public class QuestionThemeDTO {
    private UUID id;
    private String themeName;
}
