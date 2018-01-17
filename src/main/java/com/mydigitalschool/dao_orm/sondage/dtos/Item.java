package com.mydigitalschool.dao_orm.sondage.dtos;

public class Item {
	Integer id;
	Integer question_id;
	String contenu;

	public Item(Integer id, Integer question_id, String contenu) {
		this.id = id;
		this.question_id = question_id;
		this.contenu = contenu;
	}
	public Item() {	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionId() {
		return question_id;
	}
	public void setQuestionId(int questionId) {
		this.question_id = questionId;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


}
