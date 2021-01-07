package com.example.form;

import java.sql.Date;

import lombok.Data;

/**
 * ユーザーページのカレンダーの年月を受け取るフォームクラス.
 * @author fuka
 *
 */
@Data
public class ReceiveOtherUserCalendarMonthForm {

	
	//カレンダーの月の日付
	private Date date;
			
	private Integer year;
			
	private Integer month;
			
	/** ユーザ情報 */
	Integer userId;
	
}
