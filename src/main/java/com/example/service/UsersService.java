package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.mapper.UserMapper;

/**
 * ユーザーのサービスクラス.
 * 
 * @author fuka
 *
 */
@Service
@Transactional
public class UsersService {

	@Autowired
	private UserMapper mapper;

	/**
	 * 全サンプルデータを取得する.
	 * 
	 * @return サンプルデータ一覧
	 */
	public List<User> getAllUsers() {
		return mapper.findAll();
	}

	public User getUsers() {
		return mapper.selectByPrimaryKey(1);
	}

}
