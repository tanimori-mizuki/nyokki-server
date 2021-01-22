package com.example.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.DailyReport;
import com.example.domain.Following;
import com.example.domain.MonthlyReport;
import com.example.domain.Objective;
import com.example.domain.Todo;
import com.example.domain.User;
import com.example.dto.ResponseObject;
import com.example.mapper.DailyReportMapper;
import com.example.mapper.FollowingMapper;
import com.example.mapper.MonthlyReportMapper;
import com.example.mapper.ObjectiveMapper;
import com.example.mapper.TodoMapper;
import com.example.mapper.UserMapper;

/**
 * ログイン時に必要データを取得するサービス.
 * 
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class GetResponseObjectService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private TodoMapper todoMapper;

	@Autowired
	private MonthlyReportMapper monthlyReportMapper;

	@Autowired
	private DailyReportMapper dailyReportMapper;

	@Autowired
	private ObjectiveMapper objectiveMapper;

	@Autowired
	private FollowingMapper followingMapper;

	/**
	 * ログイン時にログインユーザ+必要な情報を返すメソッド.
	 * 
	 * @param gmail
	 * @return ログインユーザ+必要な情報
	 */
	public ResponseObject findAllInformation(String gmail) {

		ResponseObject responseObject = new ResponseObject();

		// ログインユーザ
		User loginUser = userMapper.findByGmail(gmail);
		// ユーザリスト
		List<User> userList = userMapper.findAll();

		// Todoリスト
		Date date = new Date();
		List<Todo> todoList = todoMapper.findAll(loginUser.getId(), date);
		// 日報情報
		DailyReport dailyReport = dailyReportMapper.findByDateAndUserID(date, loginUser.getId());

		// 今月の日報情報
		List<DailyReport> dailyReportList = dailyReportMapper.findByUserIdAndThisMonth(loginUser.getId());

//		// 今月の月報情報
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		MonthlyReport monthlyReport = monthlyReportMapper.findByDateAndUserId(loginUser.getId(), year, month);

//		// 目標情報
//		Objective objective = objectiveMapper.findByUserId(loginUser.getId());

		// フォロー一覧情報
		List<Following> followingList = followingMapper.findByUserId(loginUser.getId());

		// responseObjectに詰める処理
		responseObject.setLoginUser(loginUser);
		responseObject.setUserList(userList);
		responseObject.setTodoList(todoList);
		responseObject.setDailyReport(dailyReport);
		responseObject.setDailyReportList(dailyReportList);
		responseObject.setMonthlyReport(monthlyReport);
//		responseObject.setObjective(objective);
		responseObject.setFollowingList(followingList);

		return responseObject;
	}

}
