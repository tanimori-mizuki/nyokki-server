package com.example.form;

import com.example.domain.User;

import lombok.Data;

/**
 * 月報を保存するフォームクラス.
 * @author ashibe
 *
 */
@Data
public class SaveMonthlyReportForm {

	User loginUser;
	
	String thisMonthsGoal;
		
	String nextMonthsGoal;

	String impression;

}
