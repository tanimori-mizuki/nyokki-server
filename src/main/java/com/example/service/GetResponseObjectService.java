package com.example.service;

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
	 * @return　ログインユーザ+必要な情報
	 */
	public ResponseObject findAllInformation(String gmail) {
		
		ResponseObject responseObject = new ResponseObject();
		
		// ログインユーザ
		User loginUser = userMapper.findByGmail(gmail);
		
		// ユーザリスト
		List<User> userList = userMapper.findAll();
		
		// Todoリスト
		List<Todo> todoList = todoMapper.findAll();
		
		// 日報情報
		DailyReport dailyReport = dailyReportMapper.findByUserId(loginUser.getId());
		
		// 月報情報
		MonthlyReport monthlyReport = monthlyReportMapper.findByUserId(loginUser.getId());
		
		// 目標情報
		Objective objective = objectiveMapper.findByUserId(loginUser.getId());
		
		// フォロー一覧情報
		List<Following>followingList = followingMapper.findAll();
		
		// responseObjectに詰める処理
		responseObject.setLoginUser(loginUser);
		responseObject.setUserList(userList);
		responseObject.setTodoList(todoList);
		responseObject.setDailyReport(dailyReport);
		responseObject.setMonthlyReport(monthlyReport);
		responseObject.setObjective(objective);
		responseObject.setFollowingList(followingList);
		
		return responseObject;
	}
	

}
