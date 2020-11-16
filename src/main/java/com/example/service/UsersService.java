package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.dto.ResponseObject;
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

	public List<User> getAllUsers2() {

		List<User> userList = mapper.findAllUser();
		System.out.println("userList:" + userList.size());

		for (int i = 1; i <= userList.size(); i++) {
			User user = mapper.selectByPrimaryKey(i);
			System.out.println("userName:" + user.getName());
			System.out.println("continuationDays:" + user.getContinuationDays());
			System.out.println("-----service----");

		}
		return userList;
	}

}
