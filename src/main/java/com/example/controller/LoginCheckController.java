package com.example.controller;

import java.io.FileInputStream;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;


/**
 * フロントから送られてきたIDトークンを確認するコントローラー.
 * 
 * @author mizuki.tanimori
 *
 */
@RestController
@RequestMapping("/users")
public class LoginCheckController {
	
	@PostMapping("/loginCheck")
	public String loginCheck(@RequestParam Map<String, String> params) {
		
		String uid = "0";
		
		try {
			
			// SDKを初期化
//			FileInputStream serviceAccount =
//					new FileInputStream("path/to/serviceAccountKey.json");
//			System.out.println("FileInputStream:" + serviceAccount);

			FirebaseOptions options = FirebaseOptions.builder()
				    .setCredentials(GoogleCredentials.getApplicationDefault())
				    .setDatabaseUrl("https://nyokki-d9226.firebaseio.com")
				    .build();

//			@SuppressWarnings("deprecation")
//			FirebaseOptions options = new FirebaseOptions.Builder()
//					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
//					.setDatabaseUrl("https://nyokki-d9226.firebaseio.com")
//					.build();

			FirebaseApp.initializeApp(options);
			
			System.out.println("-------FirebaseOptionsの中身-------");
			System.out.println(options);
			
			// Token
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(params.get("idToken"));
			System.out.println("decodedTokenの中身：" + decodedToken);
			uid = decodedToken.getUid();
			System.out.println("uidの中身：" + uid);
			
		} catch (Exception e) {
			System.out.println("例外発生：" + e.getMessage());
		}
		
		return uid;
	}

}
