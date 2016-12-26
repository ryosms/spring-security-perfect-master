package com.ryosms.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by ryosms on 2016/12/21.
 */
@SpringBootApplication
@EnableRedisHttpSession
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }
}
