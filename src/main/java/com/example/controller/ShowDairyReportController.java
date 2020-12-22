package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.dto.ResponseDairyReportObject;
import com.example.form.ReceiveCalendarDateForm;
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
	private ShowDairyReportService showDairyReportService;

	/**
	 * 日報登録画面への遷移
	 * 今日の日報
	 * @param form
	 * @return
	 */
	@PostMapping("/dairyReport")
	public ResponseDairyReportObject showDairyReport(@RequestBody(required = false) ReceiveLoginUserForm form) {
		ResponseDairyReportObject responseDairyReportObject = showDairyReportService.showDairyReport(form.getLoginUser().getId());
		System.out.println(responseDairyReportObject);
		return responseDairyReportObject;
	}
	
	/**
	 * 指定した過去の日報情報
	 * @param form
	 * @param form2
	 * @return
	 */
//	@PostMapping("/pastDailyReport")
//	public ResponseDairyReportObject showPastDailyReport(@RequestBody(required = false) ReceiveLoginUserForm form, ReceiveCalendarDateForm form2) {
//		ResponseDairyReportObject responseDairyReportObject = showDairyReportService.showPastDairyReport(form.getLoginUser().getId(),form2.getDate());
//		System.out.println("日報データ通信"+ responseDairyReportObject);
//		return responseDairyReportObject;
//	}
	
	@PostMapping("/pastDailyReport")
	public void showPastDailyReport(@RequestBody(required = false) ReceiveCalendarDateForm form2 ) {
		showDairyReportService.showPastDairyReport(form2.getLoginUser().getId(),form2.getDate());
		System.out.println(form2);
		
	}
	

}
