package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.UpdateUserPhotoForm;
import com.example.service.UpdateUserPhotoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class UpdateUserPhotoController {

	@Autowired
	private UpdateUserPhotoService updateUserPhotoService;
	
	@PostMapping("/updateUserPhoto")
	public User updateUserPhoto(@RequestBody(required = false) UpdateUserPhotoForm form) {
		User user = updateUserPhotoService.updateUserPhoto(form);
		return user;
	}
}
