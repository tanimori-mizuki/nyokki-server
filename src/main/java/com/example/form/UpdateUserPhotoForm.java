package com.example.form;

import com.example.domain.User;

import lombok.Data;

@Data
public class UpdateUserPhotoForm {
	
	/** アップデートした画像 */
	private String photoUrl;
	
	/** ログインユーザー情報 */
	User loginUser;
	
}
