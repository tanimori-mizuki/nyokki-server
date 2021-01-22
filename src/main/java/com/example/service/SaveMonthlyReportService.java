package com.example.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.domain.MonthlyReport;
import com.example.domain.Objective;
import com.example.form.SaveMonthlyReportForm;
import com.example.mapper.DailyReportMapper;
import com.example.mapper.MonthlyReportMapper;
import com.example.mapper.ObjectiveMapper;

/**
 * 月報登録の為のサービスクラス.
 * 
 * @author ashibe
 *
 */
@Service
@Transactional
public class SaveMonthlyReportService {

	@Autowired
	private MonthlyReportMapper monthlyReportMapper;

	@Autowired
	private ObjectiveMapper objectiveMapper;

	public void saveMonthlyReport(SaveMonthlyReportForm form) {
		System.out.println("formの中身");
		System.out.println(form.getLoginUser().getId());
		System.out.println(form.getThisMonthsGoal());
		System.out.println(form.getImpression());
		System.out.println(form.getNextMonthsGoal());

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;

		// 今月の日報が登録されているか確認
		MonthlyReport monthlyReport = monthlyReportMapper.findByDateAndUserId(form.getLoginUser().getId(), year, month);

		if (ObjectUtils.isEmpty(monthlyReport)) {
			// 新規登録の場合
			// 今月目標
			Objective thisMonth = new Objective();
			thisMonth.setUserId(form.getLoginUser().getId());
			thisMonth.setObjective(form.getThisMonthsGoal());
			thisMonth.setObjectiveMonth(date);// これいらない？
			objectiveMapper.insertSelective(thisMonth);
			List<Objective> objectiveList = objectiveMapper.findByUserId(form.getLoginUser().getId());
			thisMonth = objectiveList.get(0);
			// 来月目標
			Objective nextMonth = new Objective();
			nextMonth.setUserId(form.getLoginUser().getId());
			nextMonth.setObjective(form.getNextMonthsGoal());
			nextMonth.setObjectiveMonth(date);// これいらない？
			objectiveMapper.insertSelective(nextMonth);
			objectiveList = objectiveMapper.findByUserId(form.getLoginUser().getId());
			nextMonth = objectiveList.get(0);

			MonthlyReport newMonthlyReport = new MonthlyReport();
			newMonthlyReport.setUserId(form.getLoginUser().getId());
			newMonthlyReport.setImpressions(form.getImpression());
			newMonthlyReport.setThisMonthObjectiveId(thisMonth.getId());
			newMonthlyReport.setNextMonthObjectiveId(nextMonth.getId());
			newMonthlyReport.setRegistrationDate(date);
			monthlyReportMapper.insertSelective(newMonthlyReport);
			

		} else {

			// 編集の場合
			System.out.println(monthlyReport.getId());
			System.out.println(monthlyReport.getThisMonthObjectiveId());
			System.out.println(monthlyReport.getNextMonthObjectiveId());
			Objective thisMonthObjective = objectiveMapper.selectByPrimaryKey(monthlyReport.getThisMonthObjectiveId());
			thisMonthObjective.setObjective(form.getThisMonthsGoal());
			objectiveMapper.updateByPrimaryKey(thisMonthObjective);

			Objective nextMonthObjective = objectiveMapper.selectByPrimaryKey(monthlyReport.getNextMonthObjectiveId());
			nextMonthObjective.setObjective(form.getNextMonthsGoal());
			objectiveMapper.updateByPrimaryKey(nextMonthObjective);

			monthlyReport.setImpressions(form.getImpression());
			monthlyReport.setRegistrationDate(date);
			monthlyReportMapper.updateByPrimaryKey(monthlyReport);

		}

	}

}
