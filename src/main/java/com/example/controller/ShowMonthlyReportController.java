package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ResponceMonthlyReportObject;
import com.example.form.ReceiveCalenderMonthForm;
import com.example.form.ReceiveOtherUserCalendarMonthForm;
import com.example.service.ShowMonthlyReportService;

/**
 * @author fuka
 *月報表示用のコントローラー
 */
@CrossOrigin
@RestController
@RequestMapping("/get")
public class ShowMonthlyReportController {
	
	private static final ResponceMonthlyReportObject RESPONCE_MONTHLY_REPORT_OBJECT = null;
	@Autowired
	private ShowMonthlyReportService showMonthlyReportService;
	
	/**
	 * マイページから月報を取得する
	 * @param form
	 * @return
	 */
	@PostMapping("/myPastMonthlyReport")
	public ResponceMonthlyReportObject showMonthlyReportObject(@RequestBody(required = false) ReceiveCalenderMonthForm form) {
		
		try {
			ResponceMonthlyReportObject responceMonthlyReportObject = showMonthlyReportService.showPastMonthlyReport(form.getLoginUser().getId(), form.getYear(), form.getMonth());
			System.out.println(responceMonthlyReportObject);
			return responceMonthlyReportObject;
			
		} catch(NullPointerException e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	/**
	 * ユーザーページから月報を取得する
	 * @param form
	 * @return
	 */
	@PostMapping("/otherUserPastMonthlyReport")
	public ResponceMonthlyReportObject showMonthlyReportObject(@RequestBody(required = false) ReceiveOtherUserCalendarMonthForm form2) {
		
		try {
			ResponceMonthlyReportObject responceMonthlyReportObject = showMonthlyReportService.showPastMonthlyReport(form2.getUserId(), form2.getYear(), form2.getMonth());
			System.out.println(responceMonthlyReportObject);
			return responceMonthlyReportObject;
			
		} catch(NullPointerException e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	
	
}
