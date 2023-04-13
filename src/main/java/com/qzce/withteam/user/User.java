package com.qzce.withteam.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @Column(nullable = false)
    private String pid;

    private String password;

    private String name;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String pid, String name, String password, String email, Role role) {
        this.pid = pid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

}