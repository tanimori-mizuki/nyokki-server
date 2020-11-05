package com.example9.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORSの設定を行うクラス.
 * 
 * @author mizuki.tanimori
 *
 */
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private EnvironmentsConfiguration envConfig;
	
	/**
	 *CORSの許可を行うメソッド
	 *環境変数に設定したオリジンのURLを許容
	 *
	 *@param registry CORSの許可一覧
	 *
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins(envConfig.getOriginUrl());
	}
}
