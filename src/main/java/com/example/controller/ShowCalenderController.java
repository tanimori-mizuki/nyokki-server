package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/get")
public class ShowCalenderController {
	
	@GetMapping("/showDailyReports")
	public void showCalender(@RequestParam Map<String, String> params) {
		System.out.println("あああ");
	}

}
