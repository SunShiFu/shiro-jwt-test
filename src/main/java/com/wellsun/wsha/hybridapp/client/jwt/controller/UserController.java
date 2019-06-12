package com.wellsun.wsha.hybridapp.client.jwt.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsun.wsha.hybridapp.client.jwt.bean.ResponseBean;
import com.wellsun.wsha.hybridapp.client.jwt.config.JWTUtil;
import com.wellsun.wsha.hybridapp.client.jwt.domain.User;
import com.wellsun.wsha.hybridapp.client.jwt.exception.UnauthorizedException;
import com.wellsun.wsha.hybridapp.client.jwt.service.UserService;
import com.wellsun.wsha.hybridapp.client.jwt.util.MD5Util;

@RestController
public class UserController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseBean login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User userBean = userService.findByUsername(username);
        logger.info("用户名"+username+";密码"+password);
        if (userBean.getPassword().equals(MD5Util.md5(password))) {
        	logger.info(username+"登录成功");
            return new ResponseBean(200, "登录成功", JWTUtil.sign(username, MD5Util.md5(password)));
        } else {
        	logger.info(username+"登录失败！");
            throw new UnauthorizedException();
        }

	}
	
    @GetMapping("/test")
    public ResponseBean article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
        	logger.info("请求成功，已登录");
            return new ResponseBean(200, "你已经登录", null);
        } else {
        	logger.info("请求成功，游客访问");
            return new ResponseBean(201, "你是游客", null);
        }
    }
    @GetMapping("/role")
    @RequiresRoles("admin")
    public ResponseBean requireRole() {
        return new ResponseBean(200, "拥有管理员权限", null);
    }

}
