package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.dto.ResponseObject;
import com.example.mapper.UserMapper;

/**
 * ログイン時に必要データを取得するサービス.
 * 
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class GetResponseObjectService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * ログイン時にログインユーザ+必要な情報を返すメソッド.
	 * 
	 * @param gmail
	 * @return　ログインユーザ+必要な情報
	 */
	public ResponseObject findAllInformation(String gmail) {
		
		ResponseObject responseObject = new ResponseObject();
		
		User loginUser = userMapper.findByGmail(gmail);
		System.out.println(loginUser);
		
		List<User> userList = userMapper.findAll();
		System.out.println(userList);
		
		responseObject.setLoginUser(loginUser);
		responseObject.setUserList(userList);
		
		System.out.println(responseObject);
		
		return responseObject;
	}
	

}
