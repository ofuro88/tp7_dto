package com.mydigitalschool.dao_orm.sondage.services;

import com.mydigitalschool.dao_orm.sondage.dtos.Item;
import com.mydigitalschool.dao_orm.sondage.dtos.ItemAndCount;
import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;
import com.mydigitalschool.dao_orm.sondage.mapper.ItemAndCountMapper;
import com.mydigitalschool.dao_orm.sondage.mapper.ReponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDuoService {

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Autowired
	ItemService itemService;

    public ItemDuoService() {
    	super();
    }
    
    public String getItemDuo(int itemId1, int itemId2){
    	String sql = "SELECT * FROM reponse\n" +
						"WHERE item_id = ?\n" +
						"AND participant_id IN(SELECT participant_id FROM reponse\n" +
												"WHERE item_id = ?);";
    	List<Reponse> reponses = jdbcTemplate.query(sql, new Object[] { itemId1, itemId2 }, new ReponseMapper());
    	int nbParticipants = reponses.size();

        return "Nombre de participants : "+nbParticipants;
    }


    // quel language => questionId = 4
	// langage javascript => itemId = 10
	// question sur activité => questionId = 2
	public String getItemOfQuestionByOtherQuestion(int questionId1 ,int itemId, int questionId2){
		String sql = "SELECT COUNT(item_id) as nbItem, item_id FROM reponse WHERE question_id = ? AND participant_id IN(\n" +
				"SELECT participant_id FROM `reponse` WHERE question_id = ? AND item_id = ?)\n" +
				"GROUP BY item_id\n" +
				"ORDER BY nbItem DESC LIMIT 1;";
		List<ItemAndCount> itemAndCounts = jdbcTemplate.query(sql,
				new Object[] { questionId2, questionId1, itemId},
				new ItemAndCountMapper());

		// récupère la première occurence (item le plus répondu)
		int TheitemId = itemAndCounts.get(0).getItemId();

		// récupère item en details
		Item item = itemService.getItem(TheitemId);

		return item.getContenu();
	}
}