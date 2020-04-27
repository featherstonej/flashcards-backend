package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cards")
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int cardId;
	
	@Column(name="cardfront", length=75)
	private String cardFront;
	
	@Column(name="cardback", length=1500)
	private String cardBack;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="topicid", referencedColumnName="topicid")
	private Topic topicHolder;
	
	public Card() {}
	
	public Card(String cardFront, String cardBack, Topic topicHolder) {
		super();
		this.cardFront = cardFront;
		this.cardBack = cardBack;
		this.topicHolder = topicHolder;
	}

	public Card(int cardId, String cardFront, String cardBack, Topic topicHolder) {
		this.cardId = cardId;
		this.cardFront = cardFront;
		this.cardBack = cardBack;
		this.topicHolder = topicHolder;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardFront() {
		return cardFront;
	}

	public void setCardFront(String cardFront) {
		this.cardFront = cardFront;
	}

	public String getCardBack() {
		return cardBack;
	}

	public void setCardBack(String cardBack) {
		this.cardBack = cardBack;
	}

	public Topic getTopicHolder() {
		return topicHolder;
	}

	public void setTopicHolder(Topic topicHolder) {
		this.topicHolder = topicHolder;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardFront=" + cardFront + ", cardBack=" + cardBack + ", topicHolder="
				+ topicHolder + "]";
	}
	
}
