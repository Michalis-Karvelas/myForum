package com.myForum.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicRequest {

    private String subject;
//    private LocalDateTime date;
    private Long accountId;
    private Long categoryId;
    private Long topicStatusId;

    public TopicRequest(Long accountId, Long categoryId) {
//        this.date = date;
        this.accountId = accountId;
        this.categoryId = categoryId;
    }

    public TopicRequest(String subject,  Long categoryId) {
        this.subject = subject;
        this.categoryId = categoryId;
    }

    public TopicRequest(String subject, Long categoryId, Long topicStatusId) {
        this.subject = subject;
        this.categoryId = categoryId;
        this.topicStatusId = topicStatusId;
    }
}
