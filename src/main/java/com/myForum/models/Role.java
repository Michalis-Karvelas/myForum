package com.myForum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "type",nullable = false)
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<Account> accounts;

    public Role(Long roleId, String type) {
        this.roleId = roleId;
        this.type = type;
    }

    public Role(String type) {
        this.type = type;
    }
}
