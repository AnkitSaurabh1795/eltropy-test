package com.eltropy.test.bankingsystem.userprofiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eltropy.test.bankingsystem.JwtAuthenticationController;
import com.eltropy.test.bankingsystem.JwtResponse;
import com.eltropy.test.bankingsystem.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserInfoRepository userInfoRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	public UserController(UserInfoRepository userInfoRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userInfoRepository = userInfoRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	@PostMapping("/signup")
	public void signUp(@RequestBody UserInfo user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userInfoRepository.save(user);
	}
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response){
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		}
		UserInfo info = this.userInfoRepository.findByUsername(username);
		LOGGER.info("UserInfo:{}",info);
		if(info == null) {
			return ResponseEntity.ok(new JwtResponse("User does not exist"));
		}
		else if (info != null && info.getToken() != null) {
			info.setToken(null);
			this.userInfoRepository.save(info);
			return ResponseEntity.ok(new JwtResponse("User is successfully logged out"));
		}
		return ResponseEntity.ok(new JwtResponse("User is already logged out"));
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

//	@PostMapping("/addEmployee")
//	public void addEmployee(@RequestBody UserInfo user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		userInfoRepository.save(user);
//	}
}
