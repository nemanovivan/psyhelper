package com.itgirls.psyhelper1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "question_themes")
public class QuestionTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private UUID id;

    @Column(name = "theme_name")
    private String theme_name;

}
