package com.myForum.services.interfaces;

import com.myForum.models.Topic;
import com.myForum.requests.TopicRequest;

import java.util.List;

public interface ITopicService {
    //a list with all the topics
    List<Topic> getAll();

    //topic found by the given id
    Topic getById(Long topicId);

    //create a new topic
    boolean newTopic(TopicRequest request);

    //update topic with the given id
    Topic updateTopic(Long topicId, TopicRequest request);

    //delete a topic with the given id or close topic
    boolean deleteTopic(Long topicId);
}
