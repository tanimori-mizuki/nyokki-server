package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Todo;
import com.example.form.RegisterTodoForm;
import com.example.service.RegisterTodoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class RegisterTodoController {
	@Autowired
	private RegisterTodoService registerTodoService;

	@PostMapping("/registerToDo")
	public List<Todo> RegisterTodo(@RequestBody(required = false) RegisterTodoForm form) {
		List<Todo> todoList = registerTodoService.RegisterTodo(form);
		return todoList;
	}

}
