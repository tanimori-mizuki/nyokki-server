package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Todo;
import com.example.dto.ResponseDairyReportObject;
import com.example.mapper.TodoMapper;

/**
 * 日報ページを表示するためのサービス
 * 
 * @author ashibe
 */
@Service
@Transactional
public class ShowDairyReportService {

	@Autowired
	private TodoMapper todoMapper;

	/**
	 * 日報ページ表示に必要な情報を取得
	 * 
	 * @param userId
	 * @return　ResponseDairyReportObject
	 */
	public ResponseDairyReportObject showDairyReport(Integer userId) {

		ResponseDairyReportObject responseDairyReportObject = new ResponseDairyReportObject();
		Date date = new Date();
		// 未完了のList
		List<Todo> uncompleteTodoList = todoMapper.todosFindByDayAndStatusAndUserId(date, 1, userId);
		responseDairyReportObject.setUncompleteTodoList(uncompleteTodoList);

		List<Todo> completeTodoList = todoMapper.todosFindByDayAndStatusAndUserId(date, 2, userId);
		responseDairyReportObject.setCompleteTodoList(completeTodoList);

		return responseDairyReportObject;

	}

}
