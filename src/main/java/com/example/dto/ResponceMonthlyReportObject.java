package com.example.dto;

import com.example.domain.MonthlyReport;
import com.example.domain.Objective;

import lombok.Data;

@Data
public class ResponceMonthlyReportObject {

	private MonthlyReport monthlyReport;

	private Objective thisMonthObjective;

	private Objective nextMonthObjective;

}
