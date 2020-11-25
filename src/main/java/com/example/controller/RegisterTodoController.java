package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.RegisterTodoForm;
import com.example.service.RegisterTodoService;

@CrossOrigin
@RestController
@RequestMapping(value ="/get")
public class RegisterTodoController {
	@Autowired
	private RegisterTodoService registerTodoService;
	
	@PostMapping("/registerToDo")
	public void RegisterTodo(@RequestBody(required=false) RegisterTodoForm form) {
	System.out.println(form.getTodos());
	System.out.println("名前："+form.getLoginUser().getName()+"メール："+form.getLoginUser().getGmail());
	registerTodoService.RegisterTodo(form);

	}

}
