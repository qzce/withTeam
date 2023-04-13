package com.qzce.withteam.user.dto;

import com.qzce.withteam.user.Role;
import com.qzce.withteam.user.User;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class UserSignDto {

    private String pid;
    private String password;
    private String email;

    public User toEntity() {
        return User.builder()
                .pid(pid)
                .password(password)
                .email(email)
                .role(Role.USER)
                .build();
    }

}
