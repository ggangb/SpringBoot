package pj1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import pj1.service.MemberService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

// 의존 객체를 생성자를 통해서 주입 
	private MemberService memberService;
	private BCryptPasswordEncoder passwordEncoder;
	private Environment env;

	public WebSecurity(MemberService memberService, BCryptPasswordEncoder passwordEncoder, Environment env) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
		this.env = env;
	}

//	   @Override
//	   protected void configure(HttpSecurity http) throws Exception { 
//	      http.formLogin();
//	      http.authorizeHttpRequests()
//	         .anyRequest().authenticated();
//	   }

// 접근 권한과 관련한 설정
//	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/**").permitAll();

// /api/member/ 아래의 리소스는 getAuthenticationFilter 필터를 통과해야 접근이 가능 
		http.authorizeRequests()
		.antMatchers("/api/member/login").permitAll()
		.antMatchers("/api/member/join").permitAll()
		.antMatchers("/api/member/**").authenticated()
		.and().addFilter(getAuthenticationFilter());
	}

	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		authenticationFilter.setAuthenticationManager(authenticationManager());
		return authenticationFilter;
	}

////인증 처리에 필요한 설정
//	// 사용자 정보를 조회할 서비스와 패스워드 암호화에 사용할 방식을 지정
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder);
//
//	}
}
