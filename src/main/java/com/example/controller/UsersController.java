package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Users;
import com.example.service.UsersService;

/**
 * ユーザーのコントローラークラス.
 * 
 * @author fuka
 *
 */
@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping("")
	public List<Users> showUsers(Model model) {
		List<Users> usersList = usersService.getAllUsers();
		// model.addAttribute("usersList", usersList);
		return usersList;
	}

}
