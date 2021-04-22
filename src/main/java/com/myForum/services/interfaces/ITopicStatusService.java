package com.myForum.services.interfaces;

import com.myForum.models.TopicStatus;
import com.myForum.requests.TopicStatusRequest;

import java.util.List;

public interface ITopicStatusService {

    //a list with all the topic statuses
    List<TopicStatus> getAll();

    //topic status found by the given id
    TopicStatus getById(Long topicStatusId);

    //create a new topic status
    boolean newTopicStatus(TopicStatusRequest request);

    //update topic status with the given id
    TopicStatus updateTopicStatus(Long topicStatusId, TopicStatusRequest request);

    //delete a topic status with the given id or close topic
    boolean deleteTopicStatus(Long topicStatusId);
}
