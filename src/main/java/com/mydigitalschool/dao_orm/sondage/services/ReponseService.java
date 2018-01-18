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
		String sql = "SELECT * FROM reponse INNER JOIN item ON reponse.item_id = item.ID "
				+ "WHERE item.question_id = "+questionId+" AND reponse.item_id = "+itemId;
		List<Reponse> item = jdbcTemplate.query(
				sql, new ReponseMapper());
		return item;
	}

	/**
	 * Cree une list d'Integer (qui renverra le nombre de reponse par question
	 * Cree une liste de reponses sur l'item
	 * Fais un.size() de la liste de reponse et l'entre dans la liste d'Integer 
	 * @return List d'Integer avec le nombre de reponses sur chaque items
	 */
	public List<Integer> getNumberOfResponseOfItem(){
		List<Integer> numberOfResponsesOnItem = new ArrayList<Integer>();
		for (int i = 0; i< itemService.getItems().size();i++) {
			String sql = "SELECT * FROM reponse WHERE item_id ="+i;
			List<Reponse> item = jdbcTemplate.query(
					sql, new ReponseMapper());
			numberOfResponsesOnItem.add(item.size());
		}
		return numberOfResponsesOnItem;


	}

	/**
	 * 
	 * @return le nombre de reponse sur chaque item en fonction de la question entrée.
	 */
	public List<Integer> countEveryResponseOnAnItemOnQuestion(Integer questionId){
		//Cree une liste de Integer
		List<Integer> list= new ArrayList<Integer>();
		//Cree une boucle pour de la taille du nombre total d'item
		for (int i = 0; i< itemService.getItems().size();i++) {
			//Regarde si pour l'item donné il ya une reponse.
			if(getItemById(questionId,i).size() !=0) {
				//Si il y a au moins une reponse, on ajoute à la liste.
				list.add(getItemById(questionId,i).size());

			}
		}
		return list;
	}
}

