package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Users;
import com.example.mapper.UsersMapper;

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
	private UsersMapper mapper;

	/**
	 * 全サンプルデータを取得する.
	 * 
	 * @return サンプルデータ一覧
	 */
	public List<Users> getAllUsers() {
		return mapper.findAll();
	}

	public Users getUsers() {
		return mapper.selectByPrimaryKey(1);
	}

}
