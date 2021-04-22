package com.myForum.services;

import com.myForum.models.Category;
import com.myForum.models.Topic;
import com.myForum.models.TopicStatus;
import com.myForum.repositories.AccountRepository;
import com.myForum.repositories.CategoryRepository;
import com.myForum.repositories.TopicRepository;
import com.myForum.repositories.TopicStatusRepository;
import com.myForum.requests.TopicRequest;
import com.myForum.services.interfaces.ITopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TopicStatusRepository topicStatusRepository;

    @Override
    public List<Topic> getAll() {
        log.info("Ready to find all the Topics");
        return topicRepository.findAll();
    }

    @Override
    public Topic getById(Long topicId) {
        log.info("Ready to find the topic with id: {}", topicId);
        return topicRepository.findById(topicId).orElse(null);
    }

    @Override
    public boolean newTopic(TopicRequest request) {
        log.info("Ready to create a topic");
        Topic tempTopic=new Topic(request.getSubject(), LocalDateTime.now(),accountRepository.findById(request.getAccountId()).orElse(null),
                categoryRepository.findById(request.getCategoryId()).orElse(null),
                topicStatusRepository.findById(1L).orElse(new TopicStatus(1L,"Open")));
        Topic newTopic=topicRepository.save(tempTopic);
        log.info("The new topic is : {}", newTopic);
        log.info("The new topic has been inserted into the DB");
        return true;
    }

    @Override
    public Topic updateTopic(Long topicId, TopicRequest request) {
        log.info("Ready to update the topic with id: {}", topicId);
        Topic existingTopic=topicRepository.findById(topicId).orElse(null);
        if (isNull(existingTopic)) {
            log.info("The topic couldn't be updated");
            return null;
        }
        existingTopic.setCategory(categoryRepository.findById(request.getCategoryId()).orElse(null));
        existingTopic.setSubject(request.getSubject());
        if (!isNull(request.getTopicStatusId())){
        existingTopic.setTopicStatus(topicStatusRepository.findById(request.getTopicStatusId()).orElse(null));
        }
        existingTopic.setDate(LocalDateTime.now()); //probably not needed
        Topic updatedTopic=topicRepository.save(existingTopic);
        log.info("The updated topic is: {}",updatedTopic);
        log.info("The updated topic has been inserted into the DB");
        return updatedTopic;
    }

    // probably not needed , update into suspended topic status
    @Override
    public boolean deleteTopic(Long topicId) {
        if (topicRepository.existsById(topicId)){
            topicRepository.deleteById(topicId);
            log.info("The topic has been successfully deleted");
            return true;
        }
        log.info("The topic couldn't be deleted");
        return false;
    }
}
