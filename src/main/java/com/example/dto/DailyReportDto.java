package com.example.dto;

import java.util.Date;
import java.util.List;

import com.example.domain.DailyReport;
import com.example.domain.Todo;

import lombok.Data;

@Data
public class DailyReportDto {

	private DailyReport dailyReport;

	private List<Todo> todoList;
}
