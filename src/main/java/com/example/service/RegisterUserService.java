package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.mapper.UserMapper;

/**
 * ログインしたGoogleアカウントをusersテーブルにインサートするサービス.
 * 
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class RegisterUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * usersテーブルにログイン情報をインサートし、ユーザを検索して返すメソッド.
	 * 
	 * @param form 
	 * @return インサートされたユーザ情報
	 */
	public User insertGoogleAccount(RegisterUserForm form) {
		
		User loginUser = new User();
		BeanUtils.copyProperties(form, loginUser);
		System.out.println(loginUser);
		
		// usersテーブルへのインサート
		userMapper.insertSelective(loginUser);
		
		// gmailでユーザを検索
		User newLoginUser = new User();
		newLoginUser = userMapper.findByGmail(loginUser.getGmail());
		
		return newLoginUser;
		
	}

}
