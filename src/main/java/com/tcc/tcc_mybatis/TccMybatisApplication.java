package com.tcc.tcc_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "com.tcc.tcc_mybatis")
@MapperScan(basePackages ="com.tcc.tcc_mybatis.dao" )
//通过此注解后可以直接用@Webserlet @WebFilter @WebListner
@ServletComponentScan
public class TccMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TccMybatisApplication.class, args);
    }

}
