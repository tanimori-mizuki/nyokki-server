package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Following;
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
		System.out.println("フォローされるID:" + form.getFollowedId());
		following.setFollowedId(form.getFollowedId());
		followingMapper.insertSelective(following);
		System.out.println("インサートされました");
		return false;
	}
	
	/**
	 * フォロー中のユーザリストを検索する処理.
	 * 
	 * @param id
	 * @return
	 */
	public List<AllUserDto> getFollowUserList(Integer id){
		
		List<AllUserDto> userList = userMapper.followUserList(id);
		return userList;
	}

}
