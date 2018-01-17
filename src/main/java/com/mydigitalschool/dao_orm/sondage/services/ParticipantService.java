package com.mydigitalschool.dao_orm.sondage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mydigitalschool.dao_orm.sondage.dtos.Participant;
import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import com.mydigitalschool.dao_orm.sondage.mapper.ParticipantMapper;
import com.mydigitalschool.dao_orm.sondage.mapper.QuestionMapper;

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

	public Participant getParticipantById(Integer id) {
		if (id> getParticipants().size()) {
			System.out.println("Aucun participant avec cet id present en base");
			return null;
		}
		String sql = "SELECT * FROM participant WHERE id = ?";
		Participant participant = (Participant) jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new ParticipantMapper());
		return participant;
	}
    

}
