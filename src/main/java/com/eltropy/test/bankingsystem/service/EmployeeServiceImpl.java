package com.eltropy.test.bankingsystem.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eltropy.test.bankingsystem.pojo.UserDetails;
import com.eltropy.test.bankingsystem.userprofiles.UserInfo;
import com.eltropy.test.bankingsystem.userprofiles.UserInfoRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDetails addEmployee(UserDetails user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		UserInfo  userInfo = userInfoRepository.save(this.beanToEntity(user));
		user.setUserid(userInfo.getUserid());
		return user;
	}
	@Override
	public void deleteEmployee(Integer userId) {
		// TODO Auto-generated method stub
		UserInfo  userInfo = userInfoRepository.findOne(userId);
		if(userInfo == null) {
			throw new RuntimeException("User Id not find");
		}
		this.userInfoRepository.save(userInfo);
	}
	public UserDetails entityToBean(UserInfo entity) {
		UserDetails user = new UserDetails();
		BeanUtils.copyProperties(entity, user);
		return user;
	}

	public UserInfo beanToEntity(UserDetails bean) {
		UserInfo user = new UserInfo();
		BeanUtils.copyProperties(bean, user);
		return user;
	}
}
