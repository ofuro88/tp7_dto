package com.mydigitalschool.dao_orm.sondage.mapper;

import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReponseMapper implements RowMapper<Reponse> {
    @Override
    public Reponse mapRow(ResultSet resultSet, int i) throws SQLException {
        Reponse reponse = new Reponse();
        reponse.setId(resultSet.getInt("id"));
        reponse.setParticipantId(resultSet.getInt("participant_id"));
        reponse.setQuestionId(resultSet.getInt("question_id"));
        reponse.setItemId(resultSet.getInt("item_id"));

        return reponse;
    }
}
