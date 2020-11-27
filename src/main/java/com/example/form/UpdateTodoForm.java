package com.example.form;

import java.util.List;

import com.example.domain.Todo;
import com.example.domain.User;

import lombok.Data;

@Data
public class UpdateTodoForm {

	User loginUser;
	List<Todo> todos;

}
