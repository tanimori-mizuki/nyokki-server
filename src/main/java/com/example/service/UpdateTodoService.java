package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.domain.Todo;
import com.example.form.UpdateTodoForm;
import com.example.mapper.TodoMapper;

/**
 * Todo編集用のサービス
 * 
 * @author ashibe
 *
 */
@Service
@Controller
public class UpdateTodoService {
	@Autowired
	private TodoMapper todoMapper;

	/**
	 * todoのステータスを変更
	 * 
	 * @param form
	 * @return Todoリスト
	 */
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