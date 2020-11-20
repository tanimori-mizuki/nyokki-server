package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
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
	
	public User insertGoogleAccount(RegisterUserForm form) {
		
	}

}
