package com.example.form;

import java.sql.Date;

import lombok.Data;

/**
 * ユーザーページのカレンダーの日付を受け取るフォームクラス.
 * 
 * @author rinashioda
 *
 */
@Data
public class ReceiveOtherUserCalendarDateForm {

	/** カレンダーの日付 */
	private Date date;

	/** ユーザ情報 */
	Integer userId;

}
