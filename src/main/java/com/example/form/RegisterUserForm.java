package com.example.form;

import lombok.Data;

@Data
public class RegisterUserForm {

	/** ログインしたGoogleアカウント名 */
	private String name;
	/** ログインしたGメールアドレス */	
	private String gmail;
	/** ログインしたユーザー画像 */	
	private String photoUrl;
}
