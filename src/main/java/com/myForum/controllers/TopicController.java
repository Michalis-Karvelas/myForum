package com.myForum.controllers;

import com.myForum.models.Topic;
import com.myForum.requests.TopicRequest;
import com.myForum.responses.Response;
import com.myForum.responses.TopicResponse;
import com.myForum.services.TopicServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@Slf4j
@RequestMapping(value = "/api/topic")
public class TopicController {

    @Autowired
    private TopicServiceImpl topicService;

    @GetMapping(value = "/getall")
    public TopicResponse getAll(){
        log.info("Controller: Ready to find all the topics");
        return new TopicResponse("Found all the topics", topicService.getAll());
    }

    @GetMapping(value = "/getbyid/{topicId}")
    public TopicResponse getById(@PathVariable(value = "topicId") Long topicId){
        log.info("Controller: Ready to find the topic with id: {}",topicId);
        return new TopicResponse("Found the topic",topicService.getById(topicId));
    }

    @PostMapping(value="/new")
    public Response createNewTopic(@RequestBody TopicRequest request){
        log.info("Controller: Ready to create a new topic");
        topicService.newTopic(request);
        log.info("The topic has been saved");
        return new Response("The topic has been inserted into the DB");
    }

    @PutMapping(value = "/update/{topicId}")
    public Response updateExistingTopic(@PathVariable(value = "topicId") Long topicId,
                                        @RequestBody TopicRequest request){
        log.info("Controller: Ready to update the topic with id: {}", topicId);
        Topic topic=topicService.updateTopic(topicId,request);
        if (isNull(topic)){
            return new Response("The topic couldn't be updated");
        }
        return new Response("The topic has been updated successfully");
    }

    @DeleteMapping(value = "/delete/{topicId}")
    public Response deleteTopic(@PathVariable(value="topicId") Long topicId){
        log.info("Controller: Ready to delete the topic with id: {}",topicId);
        if (topicService.deleteTopic(topicId)==false){
            return new Response("The topic couldn't be deleted");
        }
        return new Response("The topic has been deleted successfully");
    }
}
