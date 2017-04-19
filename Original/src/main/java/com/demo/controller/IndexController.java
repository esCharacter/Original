package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/index")
	public String HelloWorld(Model model) {
		model.addAttribute("message", "INDEX");
		return "indexInternalResource";
	}
	
	@RequestMapping(value = "/")
	public String HelloWorld() {
		return "indexInternalResource";
	}
}
