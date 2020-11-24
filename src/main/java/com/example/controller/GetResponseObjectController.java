package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ResponseObject;
import com.example.service.GetResponseObjectService;

@RestController
@CrossOrigin
@RequestMapping("/get")
public class GetResponseObjectController {
	
	@Autowired
	private GetResponseObjectService getResponseObjectService;
	
	/**
	 * ログイン時にログインユーザ+必要な情報を返すメソッド.
	 * 
	 * @param params
	 * @return　ログインユーザ+必要な情報
	 */
	@GetMapping("/Information")
	public ResponseObject getInformation(@RequestParam Map<String, String> params) {
		ResponseObject responseObject = new ResponseObject();
		System.out.println("ログインに必要な情報ID" + params.get("gmail"));
		responseObject = getResponseObjectService.findAllInformation(params.get("gmail"));
		
		return responseObject;
	}

}
