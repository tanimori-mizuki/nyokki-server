package com.example.dto;

import java.util.List;

import lombok.Data;

/**
 * マイページを開いたときに使用するフォロー・フォロワー情報
 * 
 * @author rinashioda
 *
 */
@Data
public class ResponseFollowObject {

	/** フォローリスト */
	List<AllUserDto> followList;

	/** フォロワーリスト */
	List<AllUserDto> followerList;

}
