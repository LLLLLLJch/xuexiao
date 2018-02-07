package com.situ.xuexiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Index")
public class IndexController {

	@RequestMapping("goIndex")
	public String goIndex() {
		return "index";
	}
}
