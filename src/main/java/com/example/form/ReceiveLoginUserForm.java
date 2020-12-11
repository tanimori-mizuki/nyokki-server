package com.example.form;

import com.example.domain.User;

import lombok.Data;

/**
 * ログインユーザーを受け取るフォーム
 * 
 * @author ashibe
 *
 */
@Data
public class ReceiveLoginUserForm {
	/**
	 * ログインユーザ情報
	 */
	User loginUser;

}
