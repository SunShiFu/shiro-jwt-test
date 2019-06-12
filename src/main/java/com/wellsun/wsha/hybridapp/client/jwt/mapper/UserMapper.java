package com.wellsun.wsha.hybridapp.client.jwt.mapper;

import com.wellsun.wsha.hybridapp.client.jwt.domain.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);
    
    User findByUsername(String username);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}