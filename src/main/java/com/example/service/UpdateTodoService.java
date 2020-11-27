package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.domain.Todo;
import com.example.form.UpdateTodoForm;
import com.example.mapper.TodoMapper;

@Service
@Controller
public class UpdateTodoService {
	@Autowired
	private TodoMapper todoMapper;

	public List<Todo> updateTodo(UpdateTodoForm form) {
		for (int i = 0; i < form.getTodos().size(); i++) {
			Todo todo = todoMapper.selectByPrimaryKey(form.getTodos().get(i).getId());
			todo.setStatus(2);
			System.out.println(todo);
			todoMapper.updateByPrimaryKey(todo);
		}
		List<Todo> todoList = todoMapper.findAll(form.getLoginUser().getId());
		return todoList;

	}

};