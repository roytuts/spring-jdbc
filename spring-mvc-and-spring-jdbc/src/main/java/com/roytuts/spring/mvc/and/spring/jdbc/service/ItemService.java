package com.roytuts.spring.mvc.and.spring.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.spring.mvc.and.spring.jdbc.dao.ItemDao;
import com.roytuts.spring.mvc.and.spring.jdbc.model.Item;

@Service
public class ItemService {

	@Autowired
	ItemDao itemDao;

	public List<Item> getItems() {
		return itemDao.getItems();
	}

	public void addItem(Item item) {
		itemDao.addItem(item);
	}

}
