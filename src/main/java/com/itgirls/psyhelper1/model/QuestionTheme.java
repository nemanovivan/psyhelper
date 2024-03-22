package com.itgirls.psyhelper1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "question_themes" )

public class QuestionTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID Id;

    @Column(name = "theme_name", nullable = false)
    private String themeName;

}
