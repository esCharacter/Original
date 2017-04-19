package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.dao.UserDao;
import com.demo.server.UserServer;

@Controller
public class UserController {

	@Autowired
	public UserServer userServer;
	
	@Autowired
	public UserDao userDao;
	
	@RequestMapping(value = "/Hello")
	public String HelloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "Hello";
	}

	/**
	 * 增
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addUser(Model model) {
		model.addAttribute("user", userServer.addUser("mbuser", "newm"));
		return "UserInfo";
	}

	/**
	 * 删
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{uid}")
	public String deleteUser(Model model, @PathVariable("uid") String id) {
		model.addAttribute("user", userServer.deleteUser(id));
		return "UserInfo";
	}

	/**
	 * 改
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update")
	public String updateUser(Model model) {
		model.addAttribute("user", userServer.updateUser(178, "nnnnnnnn", "123456789"));
		return "UserInfo";
	}
	
	/**
	 * 查
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user")
	public String getUser(Model model) {
		model.addAttribute("user", userServer.getUser());
		return "UserInfo";
	}
	@RequestMapping(value = "/userohter")
	public String getUserOhters(Model model) {
		model.addAttribute("user", userServer.getUserOhter());
		return "UserInfo";
	}
}