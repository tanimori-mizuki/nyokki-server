package com.example.form;

import com.example.domain.User;

import lombok.Data;

/**
 * フォロー機能で使用するフォームクラス.
 * 
 * @author rinashioda
 *
 */
@Data
public class FollowUserForm {
	
	/** ログインユーザー */
	User loginUser;
	
	/** フォローID */
	private Integer followingsId;

	/** フォローフラグ */
	private Boolean followFlag;

	/** フォローする側のユーザーID（ログインユーザID） */
	private Integer followingId;

	/** フォローされる側のユーザーID */
	private Integer followedId;

}
