package com.roytuts.spring.mvc.and.spring.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.spring.mvc.and.spring.jdbc.model.Item;

public class ItemRowMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setItemId(rs.getLong(1));
		item.setItemName(rs.getString(2));
		item.setItemPrice(rs.getDouble(3));

		return item;
	}

}
