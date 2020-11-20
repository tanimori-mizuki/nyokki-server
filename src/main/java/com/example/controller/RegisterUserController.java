package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.service.RegisterUserService;

/**
 * ログインしたGoogleアカウントをusersテーブルにインサートするコントローラ.
 * 
 * @author mizuki.tanimori
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/users")
public class RegisterUserController {

	@Autowired
	private RegisterUserService registerUserService;
	
	/**
	 * usersテーブルにインサートするメソッド.
	 * 
	 * @param form
	 * @return ログインしたユーザ情報
	 */
	@PostMapping("/register")
	public User registerUser(@RequestBody RegisterUserForm form) {
		return registerUserService.insertGoogleAccount(form);
	}
}
