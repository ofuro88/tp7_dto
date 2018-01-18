package com.mydigitalschool.dao_orm.sondage.mapper;

import com.mydigitalschool.dao_orm.sondage.dtos.Item;
import com.mydigitalschool.dao_orm.sondage.dtos.ItemAndCount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemAndCountMapper implements RowMapper<ItemAndCount> {
    @Override
    public ItemAndCount mapRow(ResultSet resultSet, int i) throws SQLException {
        ItemAndCount itemAndCount = new ItemAndCount();
        itemAndCount.setNbItem(resultSet.getInt("nbItem"));
        itemAndCount.setItemId(resultSet.getInt("item_id"));

        return itemAndCount;
    }
}
