package com.myForum.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myForum.models.TopicStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicStatusResponse extends Response{

    private TopicStatus topicStatus;
    private List<TopicStatus> topicStatusList;
    private Long topicStatusId;

    public TopicStatusResponse(String msg, TopicStatus topicStatus) {
        super(msg);
        this.topicStatus = topicStatus;
    }

    public TopicStatusResponse(String msg, List<TopicStatus> topicStatusList) {
        super(msg);
        this.topicStatusList = topicStatusList;
    }

    public TopicStatusResponse(String msg, Long topicStatusId) {
        super(msg);
        this.topicStatusId = topicStatusId;
    }
}
