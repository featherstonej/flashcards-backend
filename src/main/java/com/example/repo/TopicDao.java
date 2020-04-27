package com.example.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Topic;

@Transactional
@Repository("topicDao")
public interface TopicDao extends CrudRepository<Topic, Integer> {

	public List<Topic> findAll();
	public Topic findByTopicName(String topicName);
	public Topic findByTopicId(int topicId);
}
