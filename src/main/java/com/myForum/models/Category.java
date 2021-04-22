package com.myForum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Topic> topics;
}
