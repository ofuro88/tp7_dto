package com.mydigitalschool.dao_orm.sondage.dtos;

import java.io.Serializable;

public class Participant implements Serializable {
    public Integer id;
    public String pseudo;
    
    public Participant(Integer id, String pseudo) {
    	this.id = id;
    	this.pseudo = pseudo;
    }
    
    public Participant() {
    	
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
    
    
}
