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
    
    public List<Item> getItems(){
    	String sql = "SELECT * FROM item";
    	List<Item> item = jdbcTemplate.query(sql,
                new ItemMapper());

        return item;
    }
    
    public Item getItemById(Integer id) {
		if (id> getItems().size()) {
			System.out.println("Aucun item avec cet id present en base");
			return null;
		}
		String sql = "SELECT * FROM item WHERE question_id = ?";
		Item item = (Item) jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new ItemMapper());
		return item;
	}
}