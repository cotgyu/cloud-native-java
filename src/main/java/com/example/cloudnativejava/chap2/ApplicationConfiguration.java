package com.example.cloudnativejava.chap2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;


@SpringBootApplication // 아래설정을 부트 설정으로 대체가능!
public class ApplicationConfiguration {
//
//    @Bean(destroyMethod = "shutdown")
//    DataSource dataSource(){
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .setName("customers").build();
//    }
////
////    @Bean
////    CustomerService customerService(DataSource dataSource){
////        return new CustomerService(dataSource);
////    }
//
//    // 저수준 JDBC 대신 Jdbc Template 사용 (자원의 초기화, 획득, 해제, 예외 처리 등 공통적으로 반복되는 코드를 한 줄로 대체해주는 여러 유틸리티 메소드가 들어 있어서 개발자는 비즈니스 로직 구현에 집중할 수 있음)
//    @Bean
//    JdbcTemplate jdbcTemplate(DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
}
