package com.example.common;
//package com.example9.common;
//
//import java.util.Arrays;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Autowired
//	private EnvironmentsConfiguration envConfig;
//
//	@Bean
//	public CorsConfigurationSource corsfilter() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowCredentials(true);
//		configuration.addAllowedOrigin("http://localhost:8888");
//		configuration.setAllowedHeaders(Arrays.asList( // CORSリクエストで受信を許可するヘッダー情報(以下は例です)
//				"Access-Control-Allow-Headers", 
//				"Access-Control-Allow-Origin", 
//				"Access-Control-Request-Method",
//				"Access-Control-Request-Headers",
//				"Cache-Control", "Content-Type", 
//				"Accept-Language"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST")); // CORSリクエストを許可するHTTPメソッド
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration); // CORSリクエストを許可するURLの形式(特に決まりがなければ「/**」でもOK)
//
//		return source;
//
//	}
//
//	/**
//	 * このメソッドをオーバーライドすることで、 特定のリクエストに対して「セキュリティ設定」を無視する設定など全体にかかわる設定ができる.
//	 * 具体的には静的リソースに対してセキュリティの設定を無効にする。
//	 * 
//	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
//	 */
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/images/**", "/assets/**");
//	}
//
//	/**
//	 * このメソッドをオーバーライドすることで、認可の設定やログイン/ログアウトに関する設定ができる.
//	 * 
//	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
//	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().antMatchers("/user/**").permitAll().anyRequest().authenticated();

//		http.formLogin().loginPage("/signIn") // ログイン画面に遷移させるパス
//				.loginProcessingUrl("/nyokkiSignIn") // ログイン可否判定するパス
//				.failureUrl("/signIn?error=true") // ログイン失敗時に遷移させるパス
//				.defaultSuccessUrl("/", false); // 第1引数:デフォルトでログイン成功時に遷移させるパス
//												// 第2引数: true :認証後常に第1引数のパスに遷移
//												// false:認証されてなくて一度ログイン画面に飛ばされてもログインしたら指定したURLに遷移
//
//		http.logout() // ログアウトに関する設定
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // ログアウトさせる際に遷移させるパス
//				.logoutSuccessUrl("/signIn") // ログアウト後に遷移させるパス(ここではログイン画面を設定)
//				.deleteCookies("JSESSIONID") // ログアウト後、Cookieに保存されているセッションIDを削除
//				.invalidateHttpSession(true); // true:ログアウト後、セッションを無効にする false:セッションを無効にしない
//	}
//
//}
