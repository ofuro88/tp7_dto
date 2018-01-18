package com.mydigitalschool.dao_orm.sondage.dtos;

public class Reponse {
	Integer id;
<<<<<<< HEAD
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


=======
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
	
>>>>>>> 1e51828637c5749ddacf06aced7a6bf949ec7227
}
