package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.MonthlyReport;
import com.example.dto.ResponceMonthlyReportObject;
import com.example.mapper.MonthlyReportMapper;

/**
 * 月報ページを表示するためのサービス
 * @author fuka
 *
 */
@Service
@Transactional
public class ShowMonthlyReportService {
	
	@Autowired
	private MonthlyReportMapper monthlyReportMapper;
	
	public ResponceMonthlyReportObject showPastMonthlyReport(Integer userId, Integer year, Integer month) {
		ResponceMonthlyReportObject responceMonthlyReportObject = new ResponceMonthlyReportObject();
		
		MonthlyReport monthlyReport = monthlyReportMapper.findByDateAndUserId(userId, year, month);
		responceMonthlyReportObject.setMonthlyReport(monthlyReport);
		return responceMonthlyReportObject;
	}
	
}
