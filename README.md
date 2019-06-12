# shiro-jwt-test
SpringBoot集成Shiro和JWT简单实现无状态登录认证，废除传统的cookie-session机制认证机制

## 运行测试

1. 登录成功返回200状态码，data里面就是token，下次请求要把token放在请求头中
![运行截图](https://github.com/SunShiFu/shiro-jwt-test/blob/master/images/login.png)

2. 登录成功测试
![运行截图](https://github.com/SunShiFu/shiro-jwt-test/blob/master/images/test.png)

3. 未登录则显示游客身份
![运行截图](https://github.com/SunShiFu/shiro-jwt-test/blob/master/images/notlogin.png)

4. 有admin权限（admin用户登录）
![运行截图](https://github.com/SunShiFu/shiro-jwt-test/blob/master/images/role.png)

5. 无admin权限（test用户登录）
![运行截图](https://github.com/SunShiFu/shiro-jwt-test/blob/master/images/no_permission.png)

