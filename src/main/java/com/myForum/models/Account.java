package com.myForum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "account_status_id", nullable = false)
    private AccountStatus accountStatus;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private Set<Topic> topics;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private Set<Reply> replies;

    public Account(String username, String password, String email, Date dateOfBirth, Role role, AccountStatus accountStatus) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.accountStatus = accountStatus;
    }

    public Account(String username, String password, String email, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}
