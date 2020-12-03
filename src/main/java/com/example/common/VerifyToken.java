package com.example.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

@RestController
@RequestMapping("verify_token")
public class VerifyToken {
		
	@GetMapping("")
	public String loginCheck(HttpServletRequest request) {
		
		String uid = "0";
		//ユーザ名とパスワードが織り込まれているヘッダからトークンを取得する
        String authHeader = request.getHeader("authorization").replace("Bearer", "").replace(" ", "");
        System.out.println("------取得したAuthorization------");
        System.out.println(authHeader);
		
		try {			
			
//			FileInputStream serviceAccount =
//					new FileInputStream("path/to/serviceAccountKey.json");
//			System.out.println("FileInputStream:" + serviceAccount);
			
			// SDKを初期化
			FirebaseOptions options = FirebaseOptions.builder()
				    .setCredentials(GoogleCredentials.getApplicationDefault())
				    .setDatabaseUrl("https://nyokki-d9226.firebaseio.com")
				    .build();
//			@SuppressWarnings("deprecation")
//			FirebaseOptions options = new FirebaseOptions.Builder()
//					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
//					.setDatabaseUrl("https://nyokki-d9226.firebaseio.com")
//					.build();

			System.out.println("FirebaseOptionsの中身：" + options);
			
			// 起動しているAppを取得する
			FirebaseApp firebaseApp;
						
			// 初期済のものが存在するかチェック(リロード対処)
			List<FirebaseApp> apps = FirebaseApp.getApps();
			if (apps.size() == 0) {
				// 存在しない：新たに初期化
				firebaseApp = FirebaseApp.initializeApp(options);
			} else {
				// 存在する：そのまま返す
				firebaseApp = apps.get(0);
			}
//			FirebaseApp.initializeApp(options);
			
			
			// フロント側で発行されたトークンの取得
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(authHeader);
			System.out.println("decodedTokenの中身：" + decodedToken);
			uid = decodedToken.getUid();
			System.out.println("uidの中身：" + uid);
			
		} catch (Exception e) {
			System.out.println("例外発生：" + e.getMessage());
		}
		
		return uid;
	}

}
