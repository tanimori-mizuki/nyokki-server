package com.example.form;

import java.util.List;

import com.example.domain.Todo;
import com.example.domain.User;

import lombok.Data;

/**
 * 日報登録用のフォーム
 * 
 * @author ashibe
 *
 */
@Data
public class RegisterDailyReportForm {

	/**
	 * ログインユーザー情報
	 */
	User LoginUser;
	/**
	 * 所感
	 */
	String impression;
	/**
	 * 達成済みtodoList
	 */
	List<Todo> completeTodoList;
	/**
	 * 達成度
	 */
	Integer levelAchievementlevelAchievement;

}
