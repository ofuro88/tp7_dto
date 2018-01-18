package com.mydigitalschool.dao_orm.sondage.dtos;

public class Reponse {
	Integer id;
	Integer participantId;
	Integer questionId;
	Integer itemId;

	public Reponse(Integer id, Integer participantId, Integer questionId, Integer itemId) {
		this.id = id;
		this.participantId = participantId;
		this.questionId = questionId;
		this.itemId = itemId;
	}
	public Reponse() {	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParticipantId() {
		return questionId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


}
