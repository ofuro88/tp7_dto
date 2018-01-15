package com.mydigitalschool.dao_orm.sondage.dtos;

import java.io.Serializable;

public class Question implements Serializable {
    public Integer id;
    public String intitule;

    public Question(Integer id, String intitule) {
        this.id = id;
        this.intitule = intitule;
    }

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
