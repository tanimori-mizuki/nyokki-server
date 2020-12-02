package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.RegisterDailyReportForm;

/**
 * 日報登録のコントローラ
 * @author ashibe
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class RegisterDailyReportController {

	/**
	 * 日報登録
	 * @param form
	 */
	@PostMapping("/registerdailyReport")
	public void RegisterDairyReport(@RequestBody(required = false) RegisterDailyReportForm form) {
		System.out.println("ユーザーID"+form.getLoginUser().getId());
		System.out.println("所感"+form.getImpression());
		System.out.println(form.getCompleteTodoList().get(0));

	}

}
