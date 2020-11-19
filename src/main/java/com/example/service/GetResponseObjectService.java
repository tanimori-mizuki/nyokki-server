package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.MonthlyReport;
import com.example.domain.Todo;
import com.example.domain.User;
import com.example.dto.ResponseObject;
import com.example.mapper.MonthlyReportMapper;
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
		System.out.println(loginUser);
		
		// ユーザリスト
		List<User> userList = userMapper.findAll();
		System.out.println(userList);
		
		// Todo(日報)リスト
		List<Todo> todoList = todoMapper.findAll();
		System.out.println(todoList);
		
		// 月報情報
		MonthlyReport monthlyReport = monthlyReportMapper.findByUserId(loginUser.getId());
		System.out.println(monthlyReport);
		
		// responseObjectに詰める処理
		responseObject.setLoginUser(loginUser);
		responseObject.setUserList(userList);
		responseObject.setTodoList(todoList);
		responseObject.setMonthlyReport(monthlyReport);
		
		System.out.println(responseObject);
		
		return responseObject;
	}
	

}
