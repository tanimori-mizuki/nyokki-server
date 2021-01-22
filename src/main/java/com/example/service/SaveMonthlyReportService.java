package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.MonthlyReport;
import com.example.form.SaveMonthlyReportForm;
import com.example.mapper.DailyReportMapper;
import com.example.mapper.MonthlyReportMapper;

@Service
@Transactional
public class SaveMonthlyReportService {

	@Autowired
	private MonthlyReportMapper monthlyReportMapper;

	public void saveMonthlyReport(SaveMonthlyReportForm form) {

		MonthlyReport newMonthlyReport = new MonthlyReport();
		newMonthlyReport.setUserId(form.getLoginUser().getId());
		newMonthlyReport.setImpressions(form.getImpression());
//		newMonthlyReport.setNextMonthObjective(form.getNextMonthsGoal());
//		newMonthlyReport.setThisMonthObjective(form.getThisMonthsGoal());
		Date date = new Date();
		newMonthlyReport.setRegistrationDate(date);
		monthlyReportMapper.insertSelective(newMonthlyReport);

	}

}
