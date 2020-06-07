package com.roytuts.spring.mvc.and.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roytuts.spring.mvc.and.spring.jdbc.model.Item;
import com.roytuts.spring.mvc.and.spring.jdbc.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	@GetMapping("/")
	public String springMVC(ModelMap modelMap) {
		List<Item> items = itemService.getItems();
		System.out.println("items size: " + items.size());
		modelMap.addAttribute("itemList", items);
		modelMap.addAttribute("msg", "Welcome to Spring MVC and Spring JDBC Example");
		return "items";
	}

	@GetMapping(value = "/addPage")
	public String addPage() {
		return "add";
	}

	@PostMapping(value = "/add")
	public String addItem(@RequestParam("name") String name, @RequestParam("price") String price, ModelMap modelMap) {
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("price", price);
		if (name == null || name.trim().isEmpty()) {
			modelMap.addAttribute("error", "Item Name is required!");
		} else if (price == null || price.trim().isEmpty()) {
			modelMap.addAttribute("error", "Item Price is required!");
		} else {
			Item item = new Item();
			item.setItemName(name);
			item.setItemPrice(Double.valueOf(price));
			itemService.addItem(item);
			modelMap.addAttribute("success", "Item successfully added!");
		}
		return "add";
	}

}
