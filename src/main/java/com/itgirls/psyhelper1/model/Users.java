package com.itgirls.psyhelper1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "helper", nullable = false)
    private boolean helper;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "city")
    private String city;

    @Column(name = "about_user")
    private String aboutUser;

    @Column(name = "photo_link")
    private String photoLink;

    @ManyToOne
    @JoinColumn(name = "users_role_id")
    private UsersRole usersRole;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "assistant_id", referencedColumnName = "id")
    private Assistant assistant;

    @OneToMany(mappedBy = "users")
    private List<Answer> answers;

    @Transient
    public int getNumberOfAnswers() {
        return answers != null ? answers.size() : 0;
    }
}
