package com.wellsun.wsha.hybridapp.client.jwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wellsun.wsha.hybridapp.client.jwt.mapper")
public class WshaHybridappClientJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(WshaHybridappClientJwtApplication.class, args);
	}

}
