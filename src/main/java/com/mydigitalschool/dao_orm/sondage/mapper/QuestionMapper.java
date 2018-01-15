package com.mydigitalschool.dao_orm.sondage.mapper;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import org.flywaydb.core.internal.util.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet) throws SQLException {
        Question question = new Question();
        question.setId(resultSet.getInt("id"));
        question.setIntitule(resultSet.getString("intitule"));

        return question;
    }
}
