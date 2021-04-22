package com.myForum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "account_statuses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_status_id", nullable = false)
    private Long accountStatusId;

    @Column(name = "type",nullable = false)
    private String accountType;

    @JsonIgnore
    @OneToMany(mappedBy = "accountStatus", fetch = FetchType.LAZY)
    private Set<Account> accountSet;

}
