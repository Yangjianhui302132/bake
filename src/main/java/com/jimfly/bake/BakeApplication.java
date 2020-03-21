package com.jimfly.bake;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BakeApplication.class, args);
    }

}
