package com.mydigitalschool.dao_orm.sondage.services;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import com.mydigitalschool.dao_orm.sondage.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
        String sql = "SELECT * FROM question";
        List<Question> questions = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Question.class));

        return questions;
    }

    //Problème : QuestionMapper n'est pas vailde (il veut un type Mapper et non com . ... .QuestionMapper)
    /*public Question getQuestionsById(Integer id) {
        String sql = "SELECT * FROM question WHERE id = ?";
        String question = jdbcTemplate.query(
                sql,
                new Object[]{id},
                String.class
        );

        return question;
    }*/
}
