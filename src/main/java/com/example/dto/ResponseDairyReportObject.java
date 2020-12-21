package com.example.dto;

import java.util.List;

import com.example.domain.DailyReport;
import com.example.domain.Todo;

import lombok.Data;

@Data
public class ResponseDairyReportObject {
	
	List<Todo> uncompleteTodoList;
	
	List <Todo> completeTodoList;
	
	private DailyReport dailyReport;
	
	
	

}
