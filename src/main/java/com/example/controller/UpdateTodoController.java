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

/**
 * todo編集（完了未完了）のコントローラ
 * 
 * @author ashibe
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class UpdateTodoController {

	@Autowired
	private UpdateTodoService updateTodoService;

	/**
	 * Todo編集
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/updateToDo")
	public List<Todo> updateTodo(@RequestBody(required = false) UpdateTodoForm form) {
		List<Todo> todoList = updateTodoService.updateTodo(form);
		return todoList;

	}

}
