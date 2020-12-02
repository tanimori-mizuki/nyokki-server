package com.example.form;

import com.example.domain.User;

import lombok.Data;

@Data
public class UpdateUserNameForm {
	
	/** ログインしたGoogleアカウント名 */
	private String name;
	
	/** ログインユーザー情報 */
	User loginUser;
	
}
