package com.myForum.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myForum.models.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicResponse extends Response{

    private Topic topic;
    private List<Topic> topics;
    private Long topicId;

    public TopicResponse(String msg, Topic topic) {
        super(msg);
        this.topic = topic;
    }

    public TopicResponse(String msg, List<Topic> topics) {
        super(msg);
        this.topics = topics;
    }

    public TopicResponse(String msg, Long topicId) {
        super(msg);
        this.topicId = topicId;
    }
}
