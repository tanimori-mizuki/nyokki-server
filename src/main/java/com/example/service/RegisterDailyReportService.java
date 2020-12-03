package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.domain.DailyReport;
import com.example.domain.Todo;
import com.example.form.RegisterDailyReportForm;
import com.example.mapper.DailyReportMapper;
import com.example.mapper.TodoMapper;

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

	@Autowired
	private TodoMapper todoMapper;

	/**
	 * 日報登録
	 * 
	 * @param form
	 */
	public DailyReport registerDailyReport(RegisterDailyReportForm form) {

		Date date = new Date();
		DailyReport dailyReport = dailyReportMapper.findByDateAndUserID(date, form.getLoginUser().getId());

		Integer dailyReportId = 0;

		// その日の日報がすでに登録されているか否かを確認
		if (ObjectUtils.isEmpty(dailyReport)) {
			// 日報の作成
			dailyReport = new DailyReport();
			dailyReport.setUserId(form.getLoginUser().getId());
			dailyReport.setImpressions(form.getImpression());
			dailyReport.setLevelAchievementlevelAchievement(form.getLevelAchievementlevelAchievement());
			dailyReport.setRegistrationDate(date);
			dailyReportMapper.insertSelective(dailyReport);

			// 作成した日報のIDを取得
			List<DailyReport> dailyReportList = dailyReportMapper.findByUserId(form.getLoginUser().getId());
			dailyReportId = dailyReportList.get(0).getId();

		} else {

			// 日報情報の更新
			dailyReport.setUserId(form.getLoginUser().getId());
			dailyReport.setImpressions(form.getImpression());
			dailyReport.setLevelAchievementlevelAchievement(form.getLevelAchievementlevelAchievement());
			dailyReport.setRegistrationDate(date);
			dailyReportMapper.updateByPrimaryKey(dailyReport);

			// 更新したした日報のIDを取得
			dailyReportId = dailyReport.getId();// 最初に取得したdairyReportのId
		}
		// todoを日報に結び付け
		for (Todo todo : form.getCompleteTodoList()) {
			Todo updateTodo = todoMapper.selectByPrimaryKey(todo.getId());
			updateTodo.setDailyReportId(dailyReportId);
			todoMapper.updateByPrimaryKey(updateTodo);
		}

		dailyReport = dailyReportMapper.selectByPrimaryKey(dailyReportId);
		return dailyReport;
	}

}
