package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.dto.ResponseDairyReportObject;
import com.example.form.ReceiveLoginUserForm;
import com.example.service.ShowDairyReportService;

/**
 * 日報登録画面への遷移用のコントローラ.
 * @author ashibe
 *
 */
/**
 * @author ashibe
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/get")
public class ShowDairyReportController {
	@Autowired
	private ShowDairyReportService showDairyRepostService;

	/**
	 * 日報登録画面への遷移
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/dairyReport")
	public ResponseDairyReportObject showDairyReport(@RequestBody(required = false) ReceiveLoginUserForm form) {
		ResponseDairyReportObject responseDairyReportObject = showDairyRepostService.showDairyReport(1);
		return responseDairyReportObject;
	}

}
