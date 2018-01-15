package com.mydigitalschool.dao_orm.sondage.services;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public QuestionService() {
        super();
    }

    public List<Question> getQuestions() {
        // TODO implémenter la requête de lecture avec un RowMapper<Question>
        String sql = "select intitule from question";

        List<Question> questions  = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Question.class));
        return questions;
    }

    //Problème : QuestionMapper n'est pas vailde (il veut un type Mapper et non com . ... .QuestionMapper)
    /*public Question getQuestionsById(Integer id) {
        String sql = "SELECT * FROM Question WHERE id = ?";
        Question question = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new QuestionMapper()
        );

        return question;
    }*/
}
