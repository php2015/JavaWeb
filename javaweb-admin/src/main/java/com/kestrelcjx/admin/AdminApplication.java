package com.kestrelcjx.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kestrelcjx.**.mapper")
@SpringBootApplication(scanBasePackages = {"com.kestrelcjx.*"})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
        System.out.println("JavaWeb启动成功");
    }
}
