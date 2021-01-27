package com.example.form;

import java.sql.Date;

import com.example.domain.User;

import lombok.Data;

/**
 * ログインユーザーを受け取るフォーム
 * 
 * @author ashibe
 *
 */
@Data
public class ReceiveLoginUserForm {
	/**
	 * ログインユーザ情報
	 */
	User loginUser;
	
	/** ユーザ情報 */
	private Integer userId;
	
	//カレンダーの日付
	private Date date;
	
	private Integer year;
	
	private Integer month;

}
