package com.barry.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@EnableConfigurationProperties
public class AppConfig {
 
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public JndiPropertyHolder primary() {
        return new JndiPropertyHolder();
    }
 
//   @Bean
//   @ConfigurationProperties(prefix = "spring.datasource.secondary")
//    public JndiPropertyHolder secondary() {
//        return new JndiPropertyHolder();
//    }
 
    @Bean
    @Primary
    public DataSource primaryDataSource() {
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        DataSource dataSource = dataSourceLookup.getDataSource ( 
                                primary().getJndiName());
        return dataSource;
    }
 
//    @Bean
//    @Qualifier("graph")
//    public DataSource secondaryDataSource() {
//        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//        DataSource dataSource = dataSourceLookup.getDataSource( 
//                                secondary().getJndiName());
//        return dataSource;
//    }
// 
 
    @Bean(name = "graph")
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbctemplate1")
	public JdbcTemplate jdbcTemplate(@Qualifier("graph") DataSource dsMySQL) {
		return new JdbcTemplate(dsMySQL);
	}
 
    private static class JndiPropertyHolder {
        private String jndiName;
 
        public String getJndiName() {
            return jndiName;
        }
 
        public void setJndiName(String jndiName) {
            this.jndiName = jndiName;
        }
    }
}