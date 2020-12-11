package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AllUserDto;
import com.example.dto.ResponseFollowObject;
import com.example.form.FollowUserForm;
import com.example.service.FollowUserService;

@CrossOrigin
@RestController
@RequestMapping("/get")
public class FollowUserController {

	@Autowired
	private FollowUserService followUserService;

	/**
	 * ユーザテーブルとフォローテーブルから全件取得.
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/allUserInformation")
	public List<AllUserDto> getAllUserInformation(@RequestBody(required = false) FollowUserForm form) {
		return followUserService.getAllUserInformation(form.getLoginUser().getId());
	}

	/**
	 * ユーザテーブルとフォローテーブルからフォローリストを全件取得.
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/followAndFollowerList")
	public ResponseFollowObject getAllFollowList(@RequestBody(required = false) FollowUserForm form) {
		
		ResponseFollowObject responseFollowObject = new ResponseFollowObject();
		responseFollowObject = followUserService.getFollowAndFollowerList(form.getLoginUser().getId());
		
		return responseFollowObject;
	}
	/**
	 * フォローテーブルにインサートする.
	 * 
	 * @param form
	 */
	@PostMapping("/followRequest")
	public void follow(@RequestBody(required = false) FollowUserForm form) {

		followUserService.follow(form);
	}
	
	/**
	 * フォローフラグをfalseからtrueにして、
	 * フォローリクエストを承認する.
	 * 
	 * @param form
	 */
	@PostMapping("/approveFollowRequest")
	public void approveFollowRequest(@RequestBody(required = false) FollowUserForm form) {
		followUserService.approveFollowRequest(form);
	}
	
	/**
	 * フォローを解除する.
	 * 
	 * @param form
	 */
	@PostMapping("/unFollow")
	public void cancelFollow(@RequestBody(required = false) FollowUserForm form) {
		System.out.println("通信成功"+form);
		followUserService.deleteFollow(form);
	}


}
