package com.example.mapper;

import com.example.domain.MonthlyReport;
import com.example.domain.Objective;

import lombok.Data;

@Data
public class MonthlyReportDto {

	/**
	 * 日報
	 */
	MonthlyReport monthlyReport;

	/**
	 * 今月の目標
	 */
	Objective thisMonthObjective;

	/**
	 * 来月の目標
	 */
	Objective nextMoObjective;

}
