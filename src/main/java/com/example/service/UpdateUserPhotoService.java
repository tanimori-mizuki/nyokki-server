package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.form.UpdateUserPhotoForm;
import com.example.mapper.UserMapper;

/**
 * プロフィール画像変更機能
 * @author fuka
 *
 */
@Service
@Transactional
public class UpdateUserPhotoService {
	@Autowired
	private UserMapper userMapper;
	
	public User updateUserPhoto(UpdateUserPhotoForm form) {
		User user = userMapper.selectByPrimaryKey(form.getLoginUser().getId());
		user.setPhotoUrl(form.getPhotoUrl());
		System.out.println("画像"+ form.getPhotoUrl());
		userMapper.updateByPrimaryKey(user);
		return user;
	}
	
}
