package com.eltropy.test.bankingsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eltropy.test.bankingsystem.userprofiles.UserInfo;
import com.eltropy.test.bankingsystem.userprofiles.UserInfoRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Value("${application.user.defined}")
	private String userId;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = this.userInfoRepository.findByUsername(username);
		if (userInfo.getUsername().equals(username)) {
			return new User(userInfo.getUsername(), userInfo.getPassword(), getAuthority(userInfo));
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	private Set getAuthority(UserInfo user) {
		Set authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUserrole()));
		return authorities;
	}

}
