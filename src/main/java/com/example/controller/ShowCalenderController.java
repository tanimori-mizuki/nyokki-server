package com.example.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@GetMapping("/showDailyReports")
	public void showCalender(@RequestParam Map<String, String> params) {
		String date = params.toString();
		System.out.println("日付を加工:"+ date.substring(3,13));
	}
	
	@PostMapping("/showCalender")
	public List<DailyReport> showCalender(@RequestBody ReceiveLoginUserForm form){
		System.out.println("コントローラー" + form.getLoginUser().getId() + "中身" + form.getYear() + form.getMonth());
		List<DailyReport> dailyReports = showCalenderService.showLevelAchievement(form.getLoginUser().getId(), form.getYear(), form.getMonth());
		System.out.println("確認" + dailyReports);
		return showCalenderService.showLevelAchievement(form.getLoginUser().getId(), form.getYear(), form.getMonth());
	}
	
	
	

}
