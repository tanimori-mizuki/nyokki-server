package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.MonthlyReport;
import com.example.domain.Objective;
import com.example.dto.ResponceMonthlyReportObject;
import com.example.mapper.MonthlyReportMapper;
import com.example.mapper.ObjectiveMapper;

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
	
	@Autowired
	private ObjectiveMapper objectiveMapper;
	
	public ResponceMonthlyReportObject showPastMonthlyReport(Integer userId, Integer year, Integer month) {
		
		try {
			
		ResponceMonthlyReportObject responceMonthlyReportObject = new ResponceMonthlyReportObject();
		
		MonthlyReport monthlyReport = monthlyReportMapper.findByDateAndUserId(userId, year, month);
		Objective thisMonthObjective = objectiveMapper.selectByPrimaryKey(monthlyReport.getThisMonthObjectiveId());
		Objective nextMonthObjective = objectiveMapper.selectByPrimaryKey(monthlyReport.getNextMonthObjectiveId());
		responceMonthlyReportObject.setMonthlyReport(monthlyReport);
		responceMonthlyReportObject.setThisMonthObjective(thisMonthObjective);
		responceMonthlyReportObject.setNextMonthObjective(nextMonthObjective);
		return responceMonthlyReportObject;
		
		}catch (NullPointerException e) {
			System.err.print(e);
			return null;
		}
	}
	

	
	
}
