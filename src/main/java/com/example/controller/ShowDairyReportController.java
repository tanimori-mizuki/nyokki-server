package com.example.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ResponseDairyReportObject;
import com.example.form.ReceiveCalendarDateForm;
import com.example.form.ReceiveLoginUserForm;
import com.example.form.ReceiveOtherUserCalendarDateForm;
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

	private static final ResponseDairyReportObject responseDairyReportObject = null;
	@Autowired
	private ShowDairyReportService showDairyReportService;

	/**
	 * 日報登録画面への遷移 今日の日報
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/dairyReport")
	public ResponseDairyReportObject showDairyReport(@RequestBody(required = false) ReceiveLoginUserForm form) {
		ResponseDairyReportObject responseDairyReportObject = showDairyReportService
				.showDairyReport(form.getLoginUser().getId());
		System.out.println(responseDairyReportObject);
		return responseDairyReportObject;
	}

	/**
	 * 指定した過去の日報情報
	 * 
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


//	@PostMapping("/pastDailyReport")
//	public ResponseDairyReportObject showPastDailyReport(@RequestBody(required = false) ReceiveCalendarDateForm form2 ) {
//		ResponseDairyReportObject responseDairyReportObject = showDairyReportService.showPastDairyReport(form2.getLoginUser().getId(),form2.getDate());
//		System.out.println(form2);
//		return responseDairyReportObject;
//	}
	/**
	 * マイページから日報を取得する.
	 * 
	 * @param form2
	 * @return
	 */
	@PostMapping("/myPastDailyReport")
	public ResponseDairyReportObject showPastDailyReport(@RequestBody(required = false) ReceiveCalendarDateForm form2) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate = sdf.format(form2.getDate());

		Date sqlDate = Date.valueOf(stringDate);

		ResponseDairyReportObject responseDairyReportObject = showDairyReportService
				.showPastDairyReport(form2.getLoginUser().getId(), sqlDate);

		return responseDairyReportObject;
	}

	/**
	 *　ユーザーページから日報を取得する. 
	 * @param form
	 * @return
	 */
	@PostMapping("/otherUserPastDailyReport")
	public ResponseDairyReportObject showPastDailyReport(@RequestBody(required = false) ReceiveOtherUserCalendarDateForm form) {
		
		try {
			ResponseDairyReportObject responseDairyReportObject = showDairyReportService.showPastDairyReport(form.getUserId(),form.getDate());
			return responseDairyReportObject;

		} catch(NullPointerException e) {
			System.err.print(e);
			return null;		
		}
 		
	}

}
