package com.rest.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping(value="/web/login")
	@ResponseBody
	public String userLogin(){
		return "webLogin";
	}

	@RequestMapping(value="/api/userList")
	@ResponseBody
	public String listUsers(){
		return "Users";
	}
	
	@RequestMapping(value="/api/managerList")
	@ResponseBody
	public String listManagers(){
		return "Manageres";
	}
}
