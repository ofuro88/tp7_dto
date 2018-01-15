package com.mydigitalschool.dao_orm.sondage.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.flywaydb.core.internal.util.jdbc.RowMapper;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;

public class QuestionMapper implements RowMapper<Question>{
		
		@Override
		public Question mapRow(ResultSet rs) throws SQLException {
			Question question = new Question();
			question.setId(rs.getInt("id"));
			question.setIntitule(rs.getString("name"));
			return question;
		}
}
