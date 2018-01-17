package com.mydigitalschool.dao_orm.sondage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mydigitalschool.dao_orm.sondage.dtos.Participant;

@Service
public class ParticipantService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public ParticipantService() {
    	super();
    }

    public List<Participant> getParticipants(){
    	String sql = "SELECT * FROM participant";
    	List<Participant>participants = jdbcTemplate.query(sql,
                new ParticipantMapper());

        return participants;
    }
    

}
