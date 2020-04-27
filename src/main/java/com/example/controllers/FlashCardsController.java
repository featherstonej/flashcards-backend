package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Card;
import com.example.model.Topic;
import com.example.repo.CardDao;
import com.example.repo.TopicDao;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class FlashCardsController {

	@Autowired
	private CardDao cDao;
	
	@Autowired
	private TopicDao tDao;
	
	public FlashCardsController() {}
	
	public FlashCardsController(CardDao cDao, TopicDao tDao) {
		super();
		this.cDao = cDao;
		this.tDao = tDao;
	}
	
	@GetMapping("/getAllCards")
	public @ResponseBody List<Card> getAllCards() {
		return cDao.findAll();
	}
	
	@PostMapping("/getCardsByTopic")
	public @ResponseBody List<Card> getCardsByTopic(@RequestBody Topic topic) {
		return cDao.findByTopicHolder(topic);
	}
	
	@PostMapping("/saveCard")
	public @ResponseBody Card saveCard(@RequestBody Card card) {
		System.out.println(card);
		return cDao.save(card);
	}
	
	@GetMapping("/getAllTopics")
	public @ResponseBody List<Topic> getAllTopics() {
		return tDao.findAll();
	}
	
}

