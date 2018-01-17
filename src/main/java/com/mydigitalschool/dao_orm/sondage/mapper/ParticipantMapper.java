package com.mydigitalschool.dao_orm.sondage.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mydigitalschool.dao_orm.sondage.dtos.Participant;
import com.mydigitalschool.dao_orm.sondage.dtos.Question;

public class ParticipantMapper implements RowMapper<Participant> {
	@Override
    public Participant mapRow(ResultSet resultSet, int i) throws SQLException {
        Participant participant = new Participant();
        participant.setId(resultSet.getInt("id"));
        participant.setPseudo(resultSet.getString("pseudo"));

        return participant;
    }


}
