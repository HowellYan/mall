package com.mall.customer;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.activation.DataSource;
import javax.annotation.Resource;

@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = {"com.mall.customer.dao"})
public class CustomerApp {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }
}
