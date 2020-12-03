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

	private Integer id;

	private String name;

	private Integer continuationDays;
	
	private Integer followingsId;

	private Boolean followFlag;

	private Integer followingId;

	private Integer followedId;

}
