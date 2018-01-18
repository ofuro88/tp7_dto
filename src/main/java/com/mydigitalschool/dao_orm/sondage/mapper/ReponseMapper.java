package com.mydigitalschool.dao_orm.sondage.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;

public class ReponseMapper implements RowMapper<Reponse> {
    @Override
    public Reponse mapRow(ResultSet resultSet, int i) throws SQLException {
        Reponse reponse = new Reponse();
        reponse.setId(resultSet.getInt("id"));
        reponse.setQuestion_id(resultSet.getInt("question_id"));
        reponse.setParticipant_id(resultSet.getInt("participant_id"));
        reponse.setItem_id(resultSet.getInt("item_id"));
        
        return reponse;
    }
	

}
