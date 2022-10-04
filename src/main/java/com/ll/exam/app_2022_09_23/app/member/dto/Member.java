package com.ll.exam.app_2022_09_23.app.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    private long id;
    private String username;
    private String password;
    private String name;
    private String email;

    public boolean matchPassword(String password) {
        return this.password.substring("{noop}".length()).equals(password);
    }
}