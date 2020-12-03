package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.form.UpdateUserNameForm;
import com.example.mapper.UserMapper;

/**
 * プロフィール名変更機能
 * @author fuka
 *
 */
@Service
@Transactional
public class UpdateUserNameService {

	@Autowired
	private UserMapper userMapper;
	
	public User updateUserName(UpdateUserNameForm form) {
		
		User user = userMapper.selectByPrimaryKey(form.getLoginUser().getId());
		user.setName(form.getName());
		userMapper.updateByPrimaryKey(user);
		return user;
		
	}
	
	
}
