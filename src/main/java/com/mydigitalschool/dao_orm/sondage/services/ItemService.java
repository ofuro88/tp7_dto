package com.mydigitalschool.dao_orm.sondage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mydigitalschool.dao_orm.sondage.dtos.Item;
import com.mydigitalschool.dao_orm.sondage.dtos.Participant;
import com.mydigitalschool.dao_orm.sondage.mapper.ItemMapper;
import com.mydigitalschool.dao_orm.sondage.mapper.ParticipantMapper;

@Service
public class ItemService {

	@Autowired
    JdbcTemplate jdbcTemplate;
    public ItemService() {
    	super();
    }
    
    /**
     *  
     * @return liste de tous les items
     */
    public List<Item> getItems(){
    	String sql = "SELECT * FROM item";
    	List<Item> item = jdbcTemplate.query(sql,
                new ItemMapper());

        return item;
    }

    /**
     * 
     * @return le nombre d'items 
     */
    private int getNumberOfItems() {
    	return getItems().size();
	}

	/**
     * 
     * @param questionId
	 * @param itemId
     * @return liste des items affectés à une question.
     */
    public List<Item> getItemById(Integer questionId,Integer itemId) {
//		if (questionId> getItems().size()) {
//			System.out.println("Aucun item avec cet id present en base");
//			return null;
//		}
		
		String sql = "SELECT * FROM reponse WHERE question_id = ? AND item_id=?";
		List<Item> item = jdbcTemplate.query(
				sql, new Object[] { questionId,itemId }, new ItemMapper());
		return item;
	}
}