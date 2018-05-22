package com.createTable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Index")
public class IndexController {

	@RequestMapping("goIndex")
	public static String main(String[] args) {
		return "index";
	}
}
