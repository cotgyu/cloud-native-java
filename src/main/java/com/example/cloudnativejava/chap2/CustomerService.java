package com.example.cloudnativejava.chap2;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomerService {
//
//    private final DataSource dataSource = new EmbeddedDatabaseBuilder().setName("customers").setType(EmbeddedDatabaseType.H2).build();
//
//    public static void main(String args[]) throws Throwable {
//        CustomerService customerService = new CustomerService();
//
//        DataSource dataSource = customerService.dataSource;
//        DataSourceInitializer init = new DataSourceInitializer();
//        init.setDataSource(dataSource);
//
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.setScripts(new ClassPathResource("schema.sql"), new ClassPathResource("data.sql"));
//
//        init.setDatabasePopulator(populator);
//        init.afterPropertiesSet();
//
//        int size = customerService.findAll().size();
//        Assert.isTrue(size == 2);
//
//
//
//    }
//
//

//    // 위 설정(자원 초기화 및 획득 로직)을 외부로 뺌
//    private final DataSource dataSource;
//
//    public CustomerService(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

    private final JdbcTemplate jdbcTemplate;

    public CustomerService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public Collection<Customer> findAll() {
//        List<Customer> customerList = new ArrayList<>();
//
//        try{
//            try (Connection c = dataSource.getConnection()){
//                Statement statement = c.createStatement();
//
//                try (ResultSet rs = statement.executeQuery("select * from CUSTOMERS")){
//                    while (rs.next()){
//                        customerList.add(new Customer(rs.getLong("ID"), rs.getString("EMAIL")));
//                    }
//                }
//            }
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//        return customerList;

        RowMapper<Customer> rowMapper = (rs, i) -> new Customer(rs.getLong("ID"), rs.getString("EMAIL"));

        return this.jdbcTemplate.query("select * from CUSTOMER ", rowMapper);
    }


}
