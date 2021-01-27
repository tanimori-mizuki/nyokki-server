package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.DailyReport;
import com.example.dto.ResponseDairyReportObject;
import com.example.mapper.DailyReportMapper;

/**
 *１か月分の達成度を情報を取得する
 * @author fuka
 *
 */
@Service
@Transactional
public class ShowCalenderService {

	
	@Autowired
	private DailyReportMapper dailyReportMapper;
	

	
	public List<DailyReport> showLevelAchievement(Integer userId, Integer year, Integer month) {
		List<DailyReport> achivementList =  dailyReportMapper.findByUserIdAndLevelAchievement(userId, year, month);
		for (DailyReport dailyReport : achivementList) {
			System.out.println("サービスクラス" + dailyReport.getLevelAchievementlevelAchievement());
			System.out.println("サービスクラス2" + dailyReport.getRegistrationDate());
		}
		return achivementList ;
	}
	
	
}
