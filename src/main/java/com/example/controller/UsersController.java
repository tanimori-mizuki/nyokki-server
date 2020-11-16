package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.dto.ResponseObject;
import com.example.service.ShowTopPageService;
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

//	@Autowired
//	private UsersService usersService;
	
	@Autowired
	private ShowTopPageService showTopPageService;

	@PostMapping("")
	public ResponseObject showUsers() {
//		User user = usersService.getUsers();
//		System.out.println(user.getName()+" "+user.getId());
//		System.out.println(user.toString());
		
		ResponseObject responseObject = new ResponseObject();
		responseObject = showTopPageService.showTopPage();
		
		return responseObject;

	}
//	@PostMapping("")
//	public List<User> showUsers() {
//		List<User> userList = usersService.getAllUsers();
//		System.out.println(userList);
//		return userList;
//
//	}

}
