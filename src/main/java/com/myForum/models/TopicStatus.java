package com.myForum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "topic_statuses")
@AllArgsConstructor
@NoArgsConstructor
public class TopicStatus {

    @Id
    @Column(name = "topic_status_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicStatusId;

    @Column(name = "status_type", nullable = false)
    private String topicStatusType;

    @JsonIgnore
    @OneToMany(mappedBy = "topicStatus")
    private Set<Topic> topic;

    public TopicStatus(Long topicStatusId, String topicStatusType) {
        this.topicStatusId = topicStatusId;
        this.topicStatusType = topicStatusType;
    }
}
