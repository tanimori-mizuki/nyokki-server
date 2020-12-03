package com.example.form;

import com.example.domain.User;

import lombok.Data;

/**
 * 日報画面遷移用のフォーム
 * 
 * @author ashibe
 *
 */
@Data
public class showDairyReportForm {
	/**
	 * ログインユーザ情報
	 */
	User loginUser;

}
