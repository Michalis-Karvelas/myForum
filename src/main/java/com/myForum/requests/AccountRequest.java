package com.myForum.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {

    private String username;
    private String password;
    private String email;
    private Date dateOfBirth;
    private Long roleId;
    private Long accountStatusId;

    public AccountRequest(String username, String password, String email, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

}
