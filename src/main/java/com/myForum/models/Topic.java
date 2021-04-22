package com.myForum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "topics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id", nullable = false)
    private Long topicId;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ToString.Exclude
    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private Set<Reply> replies;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "topic_status_id",nullable = false)
    private TopicStatus topicStatus;

    public Topic(String subject, LocalDateTime date, Account account, Category category, TopicStatus topicStatus) {
        this.subject = subject;
        this.date = date;
        this.account = account;
        this.category = category;
        this.topicStatus = topicStatus;
    }
}
