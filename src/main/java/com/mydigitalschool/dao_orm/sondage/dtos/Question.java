package com.mydigitalschool.dao_orm.sondage.dtos;

import java.io.Serializable;

public class Question implements Serializable {
    public Integer id;
    public String intitule;
    
    public Integer getId() {
    	return id;
    }
    
    public String getIntitule() {
    	return intitule;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public void setIntitule(String intitule) {
    	this.intitule = intitule;
    }
}
