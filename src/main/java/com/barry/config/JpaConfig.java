//package com.barry.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@Configuration
//@EnableJpaRepositories("com.barry.repository") 
//
//public class JpaConfig {
//      
//    @Bean(name = "user")
//    public DataSource sqlDataSource() 
//    {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/user");
//        dataSourceBuilder.username("");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//    }
// 
//    @Bean(name = "graph")
//    @Primary
//    public DataSource mySqlDataSource() 
//    {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/graph");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//    }
//}