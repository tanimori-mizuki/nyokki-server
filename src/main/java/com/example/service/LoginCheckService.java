package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;

/**
 * ログインチェックするサービス.
 * 
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class LoginCheckService {
	
	public User loginCheck(String idToken) {
		
	}

}
