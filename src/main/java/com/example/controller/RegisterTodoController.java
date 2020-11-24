package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.RegisterTodoForm;


@RestController
@RequestMapping("/users")
public class RegisterTodoController {
	
	@PostMapping("/registerToDo")
	public void RegisterTodo(@RequestBody(required=false) RegisterTodoForm form) {
		System.out.println("aaa");
		System.out.println(form);
		
	}

}
