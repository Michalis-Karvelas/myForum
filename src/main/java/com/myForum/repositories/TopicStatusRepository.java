package com.myForum.repositories;

import com.myForum.models.TopicStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicStatusRepository extends JpaRepository<TopicStatus, Long> {
}
