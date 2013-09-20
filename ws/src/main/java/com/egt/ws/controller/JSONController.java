package com.egt.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egt.ws.model.Shop;

@Controller
public class JSONController {

	@RequestMapping(value = "/egt/{name}", method = RequestMethod.GET, 
			headers="Accept=application/json")
	@ResponseBody
	public Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "test1", "test2" });
		return shop;

	}
}
