package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.UpdateUserNameForm;
import com.example.service.UpdateUserNameService;

/**
 * プロフィール名変更機能.
 * @author fuka
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class updateUserNameController {
	
	@Autowired
	private UpdateUserNameService updateUserNameService;
	
	@PostMapping("/updateUserName")
	public User updateUserName(@RequestBody(required = false) UpdateUserNameForm form) {
		User user = updateUserNameService.updateUserName(form);
		return user;
	}
	
}
