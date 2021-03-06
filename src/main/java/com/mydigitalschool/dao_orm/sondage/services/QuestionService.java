package com.mydigitalschool.dao_orm.sondage.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import com.mydigitalschool.dao_orm.sondage.mapper.QuestionMapper;
import com.mysql.cj.jdbc.PreparedStatement;

@Service
public class QuestionService{


	@Autowired
	JdbcTemplate jdbcTemplate;

	public QuestionService() {
		super();
	}

	/**
	 * 
	 * @return liste des questions
	 */
	public List<Question> getQuestions() {
		String sql = "SELECT * FROM question";
		List<Question> questions = jdbcTemplate.query(sql,
				new QuestionMapper());

		return questions;
	}
	
	/**
	 * 
	 * @return nombre de questions
	 */
	public int getNumberOfQuestions() {
		return getQuestions().size();
	}
	
	
	/**
	 * 
	 * @param id
	 * @return Une question par l'id entré
	 */
	public Question getQuestionsById(Integer id) {
		if (id> getQuestions().size()) {
			return null;
		}
		String sql = "SELECT * FROM question WHERE id = ?";
		Question question = (Question) jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new QuestionMapper());
		return question;
	}
	
}
