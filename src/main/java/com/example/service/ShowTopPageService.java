package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Following;
import com.example.domain.Todo;
import com.example.domain.User;
import com.example.dto.ResponseObject;
import com.example.mapper.FollowingMapper;
import com.example.mapper.TodoMapper;
import com.example.mapper.UserMapper;

@Service
@Transactional
public class ShowTopPageService {

	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TodoMapper todoMapper;
	@Autowired
	private FollowingMapper followingMapper;

	public ResponseObject showTopPage() {
		List<User> userList = userMapper.findAll();
		List<Todo> todoList = todoMapper.findAll();
		List<Following> followingList = followingMapper.findAll();
		
		ResponseObject responseObject = new ResponseObject();
		responseObject.setUserList(userList);
		responseObject.setTodoList(todoList);
		responseObject.setFollowingList(followingList);
		
		System.out.println("ユーザーリスト" + userList);
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
			System.out.println(userList.get(i).getId());
			System.out.println(userList.get(i).getName());
		}
		System.out.println("todoリスト" + todoList);
		for (int i = 0; i < todoList.size(); i++) {
			System.out.println(todoList.get(i).getId());
			System.out.println(todoList.get(i).getTask());
		}
		System.out.println("ユーザーリスト" + followingList);
		for (int i = 0; i < followingList.size(); i++) {
			System.out.println(followingList.get(i));
			System.out.println(followingList.get(i).getId());
			System.out.println(followingList.get(i).getFollowFlag());
		}
		
		return responseObject;
	}
	
	
}
