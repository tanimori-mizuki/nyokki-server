package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Following;
import com.example.dto.AllUserDto;
import com.example.dto.ResponseFollowObject;
import com.example.form.FollowUserForm;
import com.example.mapper.FollowingMapper;
import com.example.mapper.UserMapper;

/**
 * フォロー処理とマイページでのフォロー・フォロワー取得を行う
 * 
 * @author rinashioda
 *
 */
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
	 * フォローリストとフォロワーリストを取得する処理.
	 * 
	 * @param id ユーザID
	 * @return フォロー・フォロワー情報
	 * 
	 */
	public ResponseFollowObject getFollowAndFollowerList(Integer userId) {

		ResponseFollowObject responseFollowObject = new ResponseFollowObject();

		List<AllUserDto> followList = userMapper.followUserList(userId);
		List<AllUserDto> followerList = userMapper.followerUserList(userId);

		responseFollowObject.setFollowerList(followerList);
		responseFollowObject.setFollowList(followList);

		return responseFollowObject;

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

}
