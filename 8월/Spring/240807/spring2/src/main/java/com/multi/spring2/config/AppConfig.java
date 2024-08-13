package com.multi.spring2.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
//@ComponentScan(basePackages = "com.multi")
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig created");
    }
    // 외부 클래스 빈 객체 생성 설정
    // @Bean
}


