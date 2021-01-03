package com.example.form;

import java.sql.Date;

import com.example.domain.User;

import lombok.Data;

@Data
public class ReceiveCalenderMonthForm {

		//カレンダーの月の日付
		private Date date;
		
		/**
		 * ログインユーザ情報
		 */
		User loginUser;
	
}
