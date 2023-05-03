package com.roytuts.spring.jdbctemplate.db.column.selection.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.jdbctemplate.db.column.selection.model.Item;

@Repository
public class ItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SQL_FETCH_ITEM_SPECIFIC_COLS = "SELECT item_id, item_name FROM item";
	private static final String SQL_FETCH_ITEM_SPECIFIC_COLS_LIKE = "SELECT item_id, item_name FROM item WHERE item_desc LIKE ?";

	public List<Item> fetchItems() {
		List<Map<String, Object>> records = jdbcTemplate.queryForList(SQL_FETCH_ITEM_SPECIFIC_COLS);

		List<Item> items = records.stream().map(r -> {
			Item item = new Item();
			item.setId(Integer.valueOf(String.valueOf(r.get("item_id"))));
			item.setName(String.valueOf(r.get("item_name")));
			return item;
		}).collect(Collectors.toList());

		return items;
	}

	public List<Item> fetchItemsLike(final String desc) {
		List<Map<String, Object>> records = jdbcTemplate.queryForList(SQL_FETCH_ITEM_SPECIFIC_COLS_LIKE,
				new Object[] { "%" + desc + "%" });

		List<Item> items = records.stream().map(r -> {
			Item item = new Item();
			item.setId(Integer.valueOf(String.valueOf(r.get("item_id"))));
			item.setName(String.valueOf(r.get("item_name")));
			return item;
		}).collect(Collectors.toList());

		return items;
	}

}
