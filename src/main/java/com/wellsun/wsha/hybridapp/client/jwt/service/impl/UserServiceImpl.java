package com.wellsun.wsha.hybridapp.client.jwt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsun.wsha.hybridapp.client.jwt.domain.User;
import com.wellsun.wsha.hybridapp.client.jwt.mapper.UserMapper;
import com.wellsun.wsha.hybridapp.client.jwt.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUsername(username);
	}

}
