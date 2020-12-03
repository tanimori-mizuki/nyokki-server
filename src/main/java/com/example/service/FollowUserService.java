package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.domain.Following;
import com.example.domain.User;
import com.example.dto.AllUserDto;
import com.example.form.FollowUserForm;
import com.example.mapper.FollowingMapper;
import com.example.mapper.UserMapper;

@Service
@Transactional
public class FollowUserService {

	@Autowired
	private FollowingMapper followingMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * ユーザーの一覧とフォローの状態を検索する処理.
	 * 
	 */
	public List<AllUserDto> getAllUserInformation(Integer id) {
		
		List<AllUserDto> userList = userMapper.usersInformation(id);
		
		for(int i= 0; i<userList.size(); i++) {
			System.out.println(userList.get(i));
		}
		return userList;
		
	}
	
	/**
	 * フォローテーブルにインサートする処理.
	 * 
	 * @param form
	 * @return
	 */
	public Boolean follow(FollowUserForm form) {
		
		Following following = new Following();
		following.setFollowingId(form.getLoginUser().getId());
		System.out.println("フォローされるID:"+form.getFollowedId());
		following.setFollowedId(form.getFollowedId());
		followingMapper.insertSelective(following);
		System.out.println("インサートされました");
		return false;
		
		
	}
	
	
}
