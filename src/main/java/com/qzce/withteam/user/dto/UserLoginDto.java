package com.qzce.withteam.user.dto;

import com.qzce.withteam.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {

    private String pid;
    private String password;

    public User toEntity() {
        return User.builder()
                .pid(pid)
                .password(password)
                .build();
    }
}
