package com.example.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Todo;
import com.example.form.RegisterTodoForm;
import com.example.mapper.TodoMapper;

@Service
@Transactional
public class RegisterTodoService {

	@Autowired
	private TodoMapper todoMapper;

	public List<Todo> RegisterTodo(RegisterTodoForm form) {

		for (int i = 0; i < form.getTodos().size(); i++) {
			Todo todo = new Todo();
			Date date = new Date();
			todo.setRegistrationDate(date);
			todo.setStatus(1);
			todo.setUserId(form.getLoginUser().getId());
			todo.setTask(form.getTodos().get(i).getText());
			todoMapper.insertSelective(todo);
		}
		List<Todo> todoList = todoMapper.findAll(form.getLoginUser().getId());
		return todoList;
	}

}
