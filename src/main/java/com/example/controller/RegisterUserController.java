package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.service.RegisterUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class RegisterUserController {

	@Autowired
	private RegisterUserService registerUserService;
	
	/**
	 * ログインしたGoogleアカウントをusersテーブルにインサートするサービス.
	 * 
	 * @param form
	 * @return ログインしたユーザ情報
	 */
	public User registerUser(@RequestBody RegisterUserForm form) {
		return registerUserService.insertGoogleAccount(form);
	}
}
