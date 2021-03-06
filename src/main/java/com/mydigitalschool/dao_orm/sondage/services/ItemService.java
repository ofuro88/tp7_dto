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
	 * @return 1 item demandé
	 */
	public Item getItem(Integer itemId){
		String sql = "SELECT * FROM item WHERE id = ?";
		List<Item> items = jdbcTemplate.query(sql,
				new Object[]{itemId},
				new ItemMapper());

		Item item = items.get(0);

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
     * @return liste des items affectés à une question.
     */
    public List<Item> getItemsByQuestion(Integer questionId) {		
		String sql = "SELECT * FROM item WHERE question_id = ?";
		List<Item> item = jdbcTemplate.query(
				sql, new Object[] { questionId }, new ItemMapper());
		return item;
	}
    
    
    

}