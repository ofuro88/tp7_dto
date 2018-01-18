package com.mydigitalschool.dao_orm.sondage.mapper;

<<<<<<< HEAD
import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

=======
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;

>>>>>>> 1e51828637c5749ddacf06aced7a6bf949ec7227
public class ReponseMapper implements RowMapper<Reponse> {
    @Override
    public Reponse mapRow(ResultSet resultSet, int i) throws SQLException {
        Reponse reponse = new Reponse();
        reponse.setId(resultSet.getInt("id"));
<<<<<<< HEAD
        reponse.setParticipantId(resultSet.getInt("participant_id"));
        reponse.setQuestionId(resultSet.getInt("question_id"));
        reponse.setItemId(resultSet.getInt("item_id"));

        return reponse;
    }
=======
        reponse.setQuestion_id(resultSet.getInt("question_id"));
        reponse.setParticipant_id(resultSet.getInt("participant_id"));
        reponse.setItem_id(resultSet.getInt("item_id"));
        
        return reponse;
    }
	

>>>>>>> 1e51828637c5749ddacf06aced7a6bf949ec7227
}
