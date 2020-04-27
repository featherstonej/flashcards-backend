package com.example.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Card;
import com.example.model.Topic;

@Transactional
@Repository("cardDao")
public interface CardDao extends CrudRepository<Card, Integer> {

	public List<Card> findAll();
	public List<Card> findByTopicHolder(Topic topic);
	public Card findById(int id);
}
