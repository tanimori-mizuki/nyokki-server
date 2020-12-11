package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.DailyReport;
import com.example.form.ReceiveLoginUserForm;
import com.example.service.ShowCalenderService;

@CrossOrigin
@RestController
@RequestMapping("/get")
public class ShowCalenderController {
		
	@Autowired
	private ShowCalenderService showCalenderService;
	
	@PostMapping("/showCalender")
	public List<DailyReport> showCalender(@RequestBody ReceiveLoginUserForm form){
		System.out.println("コントローラー" + form.getLoginUser().getId());
		return showCalenderService.showLevelAchievement(form.getLoginUser().getId());
	}
	
	
	
}
