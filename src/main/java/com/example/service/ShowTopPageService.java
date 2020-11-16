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

@Service
@Transactional
public class ShowTopPageService {

	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TodoMapper todoMapper;
	@Autowired
	private FollowingMapper followingMapper;
	@Autowired
	private DailyReportMapper dailyReportMapper;
	@Autowired
	private MonthlyReportMapper monthlyReportMapper;
	@Autowired
	private ObjectiveMapper objectiveMapper;
	

	public ResponseObject showTopPage() {
		List<User> userList = userMapper.findAll();
		List<Todo> todoList = todoMapper.findAll();
		List<Following> followingList = followingMapper.findAll();
		DailyReport dailyReport = dailyReportMapper.selectByPrimaryKey(1);
		MonthlyReport monthlyReport = monthlyReportMapper.selectByPrimaryKey(1);
		Objective objective = objectiveMapper.selectByPrimaryKey(1);
	
		ResponseObject responseObject = new ResponseObject();
		responseObject.setUserList(userList);
		responseObject.setTodoList(todoList);
		responseObject.setFollowingList(followingList);
		responseObject.setDailyReport(dailyReport);
		responseObject.setMonthlyReport(monthlyReport);
		responseObject.setObjective(objective);
		
		System.out.println("ユーザーリスト" + userList);
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
			System.out.println(userList.get(i).getId());
			System.out.println(userList.get(i).getName());
		}
		System.out.println("todoリスト" + todoList);
		for (int i = 0; i < todoList.size(); i++) {
			System.out.println(todoList.get(i).getId());
			System.out.println(todoList.get(i).getTask());
		}
		System.out.println("ユーザーリスト" + followingList);
		for (int i = 0; i < followingList.size(); i++) {
			System.out.println(followingList.get(i));
			System.out.println(followingList.get(i).getId());
			System.out.println(followingList.get(i).getFollowFlag());
			
		System.out.println("日報データ一行分" + dailyReport);
		System.out.println(dailyReport.getId()+" "+dailyReport.getTodayReport());
		System.out.println(dailyReport.toString());
		
		System.out.println("月報データ一行分" + monthlyReport);
		System.out.println(monthlyReport.getId()+" "+monthlyReport.getImpressions());
		System.out.println(monthlyReport.toString());
		
		System.out.println("目標データ一行分" + objective);
		System.out.println(objective.getId()+" "+objective.getObjective());
		System.out.println(objective.toString());
		}
		
		
		return responseObject;
	}
	
	
}
