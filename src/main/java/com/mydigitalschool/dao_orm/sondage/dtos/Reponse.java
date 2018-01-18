package com.mydigitalschool.dao_orm.sondage.dtos;

public class Reponse {
	Integer id;
	Integer question_id;
	Integer participant_id;
	Integer item_id;
	
	public Reponse() {	
		this.id = id;
		this.question_id=question_id;
		this.participant_id= participant_id;
		this.item_id = item_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public Integer getParticipant_id() {
		return participant_id;
	}

	public void setParticipant_id(Integer participant_id) {
		this.participant_id = participant_id;
	}

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	
}
