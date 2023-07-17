//package com.casestudy.CartService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.casestudy.CartService.entity.JwtUtil;
//import com.casestudy.CartService.jwtfilter.JwtFilter;
//import com.casestudy.CartService.service.MyUserDetailsService;
//
//@SuppressWarnings({ "deprecation", "unused" })
//@EnableWebSecurity
//public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private MyUserDetailsService myUserDetailsService;
//
//	@Autowired
//	private JwtFilter jwtRequestFilter;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(myUserDetailsService);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/cart/reg", "/cart/authenticate").permitAll()
//				.anyRequest().authenticated().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//}
