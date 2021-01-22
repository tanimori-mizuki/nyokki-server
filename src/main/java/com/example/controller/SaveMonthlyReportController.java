package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.SaveMonthlyReportForm;
import com.example.service.SaveMonthlyReportService;

@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class SaveMonthlyReportController {

	@Autowired
	private SaveMonthlyReportService saveMonthlyReportService;

	@PostMapping("/saveMonthlyReport")
	public void saveMonthlyReport(@RequestBody SaveMonthlyReportForm form) {
		saveMonthlyReportService.saveMonthlyReport(form);

	}

}
