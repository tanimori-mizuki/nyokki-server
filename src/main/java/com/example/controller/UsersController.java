package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Users;
import com.example.service.UsersService;

/**
 * ユーザーのコントローラークラス.
 * 
 * @author fuka
 *
 */
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@PostMapping("")
	public List<Users> showUsers() {
		List<Users> usersList = usersService.getAllUsers();
		// model.addAttribute("usersList", usersList);
		System.out.println(usersList);
		return usersList;
	}

}
