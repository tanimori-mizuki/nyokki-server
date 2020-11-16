package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.UsersService;

@RestController
@CrossOrigin
public class ShowSignInController {

	@Autowired
	private UsersService usersService;

	@PostMapping("/user/signIn")
	public List<User> signInPage() {

		System.out.println("呼び出し成功");

		List<User> userList = usersService.getAllUsers2();
		
		System.out.println("（C）userList:" + userList);
		
		//多分ここが違う
		for(int i=0; i <userList.size(); i++ ) {
			System.out.println(userList.get(i).getName()+ ":" + userList.get(i).getLevelAchievement());
		}
		
		return userList;
	}

//	@PostMapping("/signIn")
//	public String signInPage2() {
//		System.out.println("呼び出し失敗");
//		return "いいい";
//	}

}
