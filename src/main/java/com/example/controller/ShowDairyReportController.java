package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.dto.ResponseDairyReportObject;
import com.example.form.showDairyReportForm;
import com.example.service.ShowDairyReportService;

@CrossOrigin
@RestController
@RequestMapping("/get")
public class ShowDairyReportController {
	@Autowired
	private ShowDairyReportService showDairyRepostService;

	@GetMapping("/dairyReport")
	public ResponseDairyReportObject showDairyReport(@RequestBody(required = false) showDairyReportForm form) {
		//System.out.println(form.getLoginUser().getId());
		ResponseDairyReportObject responseDairyReportObject = showDairyRepostService
				.showDairyReport(4);
		return responseDairyReportObject;
	}

}
