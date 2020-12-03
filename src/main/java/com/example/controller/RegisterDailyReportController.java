package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.DailyReport;
import com.example.form.RegisterDailyReportForm;
import com.example.service.RegisterDailyReportService;

/**
 * 日報登録のコントローラ
 * 
 * @author ashibe
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class RegisterDailyReportController {

	@Autowired
	private RegisterDailyReportService registerDailyReportService;

	/**
	 * 日報登録
	 * 
	 * @param form
	 */
	@PostMapping("/registerdailyReport")
	public DailyReport RegisterDairyReport(@RequestBody(required = false) RegisterDailyReportForm form) {
		DailyReport dailyReport = registerDailyReportService.registerDailyReport(form);
		return dailyReport;
	}

}
