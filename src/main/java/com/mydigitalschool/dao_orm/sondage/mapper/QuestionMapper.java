package com.mydigitalschool.dao_orm.sondage.mapper;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {
        Question question = new Question();
        question.setId(resultSet.getInt("id"));
        question.setIntitule(resultSet.getString("intitule"));

        return question;
    }
}
