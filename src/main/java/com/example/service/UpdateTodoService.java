package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Todo;
import com.example.form.UpdateTodoForm;
import com.example.mapper.TodoMapper;

@Service
@Transactional
public class UpdateTodoService {
	@Autowired
	private TodoMapper todoMapper;

	public List<Todo> updateTodo(UpdateTodoForm form) {
		for (int i = 0; i < form.getTodos().size(); i++) {
			Todo todo = todoMapper.selectByPrimaryKey(form.getTodos().get(i).getId());
			todo.setStatus(form.getTodos().get(i).getStatus());
			todoMapper.updateByPrimaryKey(todo);
		}
		Date date = new Date();
		List<Todo> todoList = todoMapper.findAll(form.getLoginUser().getId(), date);
		return todoList;
	}

};