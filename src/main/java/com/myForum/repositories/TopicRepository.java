package com.myForum.repositories;

import com.myForum.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
}
