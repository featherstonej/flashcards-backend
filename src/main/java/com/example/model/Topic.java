package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="topics")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cards"})
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="topicid")
	private int topicId;
	
	@Column(name="topicname", length=30)
	private String topicName;
	
	
	@OneToMany(mappedBy="topicHolder", fetch=FetchType.EAGER)
	private List<Card> cards = new ArrayList<>();
	
	public Topic() {}	
	
	public Topic(String topicName) {
		super();
		this.topicName = topicName;
	}

	public Topic(int topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topic=" + topicName + "]";
	}
	
}
