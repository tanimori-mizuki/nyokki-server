package com.example.form;

import java.util.List;

import com.example.domain.Todo;
import com.example.domain.User;

import lombok.Data;

/**
 * todo編集（完了未完了）用のフォーム
 * 
 * @author ashibe
 *
 */
@Data
public class UpdateTodoForm {

	/**
	 * ログインユーザ情報
	 */
	User loginUser;
	/**
	 * todoリスト
	 */
	List<Todo> todos;
}
