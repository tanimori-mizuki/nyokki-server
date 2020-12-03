package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.DailyReport;
import com.example.form.RegisterDailyReportForm;
import com.example.mapper.DailyReportMapper;

/**
 * 日報登録のためのサービスクラス
 * 
 * @author ashibe
 *
 */
@Service
@Transactional
public class RegisterDailyReportService {

	@Autowired
	private DailyReportMapper dailyReportMapper;

	/**
	 * 日報登録
	 * 
	 * @param form
	 */
	public void registerDailyReport(RegisterDailyReportForm form) {

		Date date = new Date();
		DailyReport dailyReport = new DailyReport();
		dailyReport.setUserId(form.getLoginUser().getId());
		dailyReport.setImpressions(form.getImpression());
		dailyReport.setLevelAchievementlevelAchievement(form.getLevelAchievementlevelAchievement());
		dailyReport.setRegistrationDate(date);
		dailyReportMapper.insertSelective(dailyReport);

	}

}
