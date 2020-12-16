package com.example.dto;

import lombok.Data;

/**
 * みんなの達成度一覧で使用する.
 * 
 * @author rinashioda
 *
 */
@Data
public class AllUserDto {

	/** ユーザID */
	private Integer id;

	/** 名前 */
	private String name;

	/** 継続日数 */
	private Integer continuationDays;

	/** アイコン */
	private String photoUrl;

	/** フォローID */
	private Integer followingsId;

	/** フォローフラグ */
	private Boolean followFlag;

	/** フォローする側のID */
	private Integer followingId;

	/** フォローされる側のID */
	private Integer followedId;

}
