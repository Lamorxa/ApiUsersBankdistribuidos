package com.bank.USERS_API.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    private String name;
    private String username;
    private String password;
    private int userId;

}
