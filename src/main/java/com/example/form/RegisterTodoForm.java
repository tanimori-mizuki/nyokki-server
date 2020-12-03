package com.example.form;

import java.util.List;

import com.example.domain.User;
import com.example.dto.TodoDto;

import lombok.Data;

/**
 * todo登録用のフォーム
 * @author ashibe
 *
 */
@Data
public class RegisterTodoForm {

	/**
	 * 登録するTodoリスト
	 */
	List<TodoDto> todos;
	/**
	 * ログインユーザ情報
	 */
	User loginUser;

}
