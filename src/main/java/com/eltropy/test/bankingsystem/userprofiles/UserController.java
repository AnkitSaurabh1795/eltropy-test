package com.eltropy.test.bankingsystem.userprofiles;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserInfoRepository userInfoRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public UserController(UserInfoRepository userInfoRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userInfoRepository = userInfoRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	@PostMapping("/signup")
	public void signUp(@RequestBody UserInfo user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userInfoRepository.save(user);
	}
//	@PostMapping("/addEmployee")
//	public void addEmployee(@RequestBody UserInfo user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		userInfoRepository.save(user);
//	}
}
