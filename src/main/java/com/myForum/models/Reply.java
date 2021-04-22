package com.myForum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "replies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id", nullable = false)
    private Long replyId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "topic_id",nullable = false)
    private Topic topic;

}
