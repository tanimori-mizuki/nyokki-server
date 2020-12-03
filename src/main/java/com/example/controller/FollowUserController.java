package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AllUserDto;
import com.example.form.FollowUserForm;
import com.example.service.FollowUserService;

@CrossOrigin
@RestController
@RequestMapping("/get")
public class FollowUserController {
	
	@Autowired
	private FollowUserService followUserService;
	
	/**
	 * フォローテーブルから取得.
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/allUserInformation")
	public List<AllUserDto> getAllUserInformation(@RequestBody(required=false) FollowUserForm form) {
		System.out.println("ログインユーザID:"+ form.getLoginUser().getId());
		return followUserService.getAllUserInformation(form.getLoginUser().getId());
	}
	
	/**
	 * フォローテーブルに登録する.
	 * 
	 * @param form
	 */
	@PostMapping("/followRequest")
	public void follow(@RequestBody(required=false) FollowUserForm form) {
		
		System.out.println("通信成功");
		System.out.println("ログインユーザID" + form.getLoginUser().getId());
		System.out.println("ログインユーザ名前" + form.getLoginUser().getName());
		
		followUserService.follow(form);
	}

}
