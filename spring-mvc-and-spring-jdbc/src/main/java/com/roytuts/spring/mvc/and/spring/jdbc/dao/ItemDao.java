package com.roytuts.spring.mvc.and.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.mvc.and.spring.jdbc.model.Item;
import com.roytuts.spring.mvc.and.spring.jdbc.rowmapper.ItemRowMapper;

@Repository
public class ItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Item> getItems() {
		String sql = "SELECT * FROM items";
		List<Item> items = new ArrayList<>();
		items = jdbcTemplate.query(sql, new ItemRowMapper());
		return items;
	}

	public void addItem(Item item) {
		String sql = "INSERT INTO items(item_name,item_price) VALUES (?,?);";
		jdbcTemplate.update(sql, new Object[] { item.getItemName(), item.getItemPrice() });
	}

}
