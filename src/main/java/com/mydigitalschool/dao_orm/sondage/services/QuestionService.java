package com.mydigitalschool.dao_orm.sondage.services;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Question> getQuestions() {
        // TODO implémenter la requête de lecture avec un RowMapper<Question>
    	String SQL = "select intitule from question";

    	
            
        throw new UnsupportedOperationException();
    }
}
