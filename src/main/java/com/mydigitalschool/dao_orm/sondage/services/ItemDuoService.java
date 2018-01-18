package com.mydigitalschool.dao_orm.sondage.services;

import com.mydigitalschool.dao_orm.sondage.dtos.Item;
import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;
import com.mydigitalschool.dao_orm.sondage.mapper.ItemMapper;
import com.mydigitalschool.dao_orm.sondage.mapper.ReponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDuoService {

	@Autowired
    JdbcTemplate jdbcTemplate;
    public ItemDuoService() {
    	super();
    }
    
    public int getItemDuo(int itemId1, int itemId2){
    	String sql = "SELECT * FROM reponse\n" +
						"WHERE item_id = ?\n" +
						"AND participant_id IN(SELECT participant_id FROM reponse\n" +
												"WHERE item_id = ?);";
    	List<Reponse> reponses = jdbcTemplate.query(sql, new Object[] { itemId1, itemId2 }, new ReponseMapper());
    	int nbParticipants = reponses.size();

        return nbParticipants;
    }
}