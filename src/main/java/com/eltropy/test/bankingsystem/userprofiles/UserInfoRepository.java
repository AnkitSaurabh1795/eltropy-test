package com.eltropy.test.bankingsystem.userprofiles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
	UserInfo findByUsername(String username);

}
