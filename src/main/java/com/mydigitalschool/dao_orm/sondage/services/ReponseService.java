package com.mydigitalschool.dao_orm.sondage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;
import com.mydigitalschool.dao_orm.sondage.mapper.ReponseMapper;
import com.mydigitalschool.dao_orm.sondage.services.ItemService;
import com.mydigitalschool.dao_orm.sondage.services.ParticipantService;
import com.mydigitalschool.dao_orm.sondage.services.QuestionService;

@Service
public class ReponseService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @Autowired
    QuestionService questionService;
    
    @Autowired
    ParticipantService participantService;

    @Autowired
    ItemService itemService;
    


	 public List<Reponse> getItemById(Integer questionId,Integer itemId) {
//			if (questionId> getItems().size()) {
//				System.out.println("Aucun item avec cet id present en base");
//				return null;
//			}
			
			String sql = "SELECT * FROM reponse INNER JOIN item ON reponse.item_id = item.ID "
					+ "WHERE item.question_id = "+questionId;
			List<Reponse> item = jdbcTemplate.query(
					sql, new ReponseMapper());
			return item;
		}
	 
	 /**
	  * 
	  * @return le nombre de reponse sur chaque item en fonction de la question entrée.
	  */
	 public List<Integer> countEveryResponseOnAnItemOnQuestion(Integer questionId){
		 List<Integer> list= new ArrayList<Integer>();
		 
		 for (int i = 1; i<itemService.getItems().size()+1;i++) {
				 list.add(getItemById(questionId, i).size());
			 
		 }
		 return list;
		 
			 
		 }
	 }

