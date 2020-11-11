package com.example9.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ShowSignInController {

	@PostMapping("/user/signIn")
	public String signInPage() {
		System.out.println("呼び出し成功");
		return "あああ";
	}

	@PostMapping("/signIn")
	public String signInPage2() {
		System.out.println("呼び出し失敗");
		return "いいい";
	}

}
