package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Todo;
import com.example.form.UpdateTodoForm;
import com.example.service.UpdateTodoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class UpdateTodoController {

	@Autowired
	private UpdateTodoService updateTodoService;

	@PostMapping("/updateToDo")
	public List<Todo> updateTodo(@RequestBody(required = false) UpdateTodoForm form) {
		List<Todo> todoList = updateTodoService.updateTodo(form);
		return todoList;

	}

}
