package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		System.out.println("ログインユーザName：" + form.getName());
		System.out.println("ログインユーザGmail：" + form.getGmail());
		User loginUser = new User();
		System.out.println(form.getPhotoUrl());
		BeanUtils.copyProperties(form, loginUser);
		loginUser.setContinuationDays(0);
		loginUser.setFirstdayContinuation(new Date());
		loginUser.setLevelAchievement(0);
		
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loginUser.getFirstdayContinuation());
		System.out.println("登録日" + date);
		
		// usersテーブルへのインサート
		userMapper.insertSelective(loginUser);
		
		// gmailでユーザを検索
		User newLoginUser = new User();
		newLoginUser = userMapper.findByGmail(loginUser.getGmail());
		System.out.println("再検索ユーザId：" + newLoginUser.getId());
		
		return newLoginUser;
		
	}

}
