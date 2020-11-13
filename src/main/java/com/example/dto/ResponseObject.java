package com.example.dto;

import java.util.List;

import com.example.domain.DailyReport;
import com.example.domain.Following;
import com.example.domain.MonthlyReport;
import com.example.domain.Objective;
import com.example.domain.Todo;
import com.example.domain.User;

import lombok.Data;

/**
 * ログインと同時に持ってくるデータ情報
 * 
 * @author mizuki.tanimori
 *
 */
@Data
public class ResponseObject {

	/** ユーザ一覧 */
	private List<User> userList;
	/** Todo一覧 */
	private List<Todo> todoList;
	/** 日報情報 */
	private DailyReport dailyReport;
	/** 月報情報 */
	private MonthlyReport monthlyReport;
	/** 目標情報 */
	private Objective objective;
	/** フォロー一覧 */
	private List<Following> followingList;
}
