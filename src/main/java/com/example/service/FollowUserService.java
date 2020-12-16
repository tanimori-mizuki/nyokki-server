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
	 * フォロー許可が承認される前なのでフォローフラグはfalse.
	 * 
	 * @param form
	 * @return
	 */
	public void follow(FollowUserForm form) {

		Following following = new Following();
		following.setFollowingId(form.getLoginUser().getId());
		following.setFollowedId(form.getFollowedId());
		followingMapper.insertSelective(following);

	}

	/**
	 * フォローリクエストを承認する処理. 
	 * フォローフラグをtrueにする.
	 * 
	 * @param form
	 */
	public void approveFollowRequest(FollowUserForm form) {

		Following following = new Following();
		following.setId(form.getFollowingsId());
		following.setFollowingId(form.getFollowingId());
		following.setFollowedId(form.getFollowedId());
		following.setFollowFlag(true);
		followingMapper.updateByPrimaryKey(following);

		ResponseFollowObject responseFollowObject = new ResponseFollowObject();

		List<AllUserDto> followerList = userMapper.followerUserList(form.getLoginUser().getId());

		responseFollowObject.setFollowerList(followerList);

	}

	/**
	 * フォローテーブルからフォロー情報を削除する処理. 
	 * フォローリストからフォローを解除する時に使用.
	 * 
	 * @param form
	 */
	public void deleteFollow(FollowUserForm form) {
		followingMapper.deleteByPrimaryKey(form.getFollowingsId());

	}

	/**
	 * フォローテーブルからフォロワー情報を削除する処理. 
	 * フォロワーリストからフォロー申請を否認する時に使用.
	 * 
	 * @param form
	 */
	public void denyFollowRequest(FollowUserForm form) {
		followingMapper.deleteByPrimaryKey(form.getFollowingsId());
	}

}
