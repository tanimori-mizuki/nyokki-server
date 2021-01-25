package com.example.form;

import com.example.domain.User;

import lombok.Data;

@Data
public class UpdateUserNameForm {
	
	/** アップデートした名前 */
	private String name;
	
	/** ログインユーザー情報 */
	User loginUser;
	
}
