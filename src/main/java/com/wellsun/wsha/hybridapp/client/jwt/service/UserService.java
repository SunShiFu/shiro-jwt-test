package com.wellsun.wsha.hybridapp.client.jwt.service;

import com.wellsun.wsha.hybridapp.client.jwt.domain.User;

public interface UserService {
	User findByUsername(String username);

}
