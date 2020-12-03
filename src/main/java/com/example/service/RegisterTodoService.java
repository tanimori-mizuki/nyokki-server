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

/**
 * Todo登録のサービス
 * 
 * @author ashibe
 *
 */
@Service
@Transactional
public class RegisterTodoService {

	@Autowired
	private TodoMapper todoMapper;

	/**
	 * Todo登録処理
	 * 
	 * @param form
	 * @return todo一覧
	 */
	public List<Todo> RegisterTodo(RegisterTodoForm form) {
		Date date = new Date();
		Integer status = 1;
		for (int i = 0; i < form.getTodos().size(); i++) {
			Todo todo = new Todo();
			todo.setRegistrationDate(date);
			todo.setStatus(status);
			todo.setUserId(form.getLoginUser().getId());
			todo.setTask(form.getTodos().get(i).getTask());
			todoMapper.insertSelective(todo);
		}
		List<Todo> todoList = todoMapper.todosFindByDayAndStatusAndUserId(date, status, form.getLoginUser().getId());
		return todoList;
	}

}
