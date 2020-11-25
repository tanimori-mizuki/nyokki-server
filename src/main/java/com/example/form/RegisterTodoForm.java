package com.example.form;

import java.util.List;

import com.example.domain.User;
import com.example.dto.TodoDto;

import lombok.Data;

@Data
public class RegisterTodoForm {

	List<TodoDto> todos;
	User loginUser;

}
