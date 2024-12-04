/*  // Alternate way
package org.example.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    // Configure DataSource
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/your_database");
        dataSource.setUsername("your_username");
        dataSource.setPassword("your_password");
        return dataSource;
    }

    // Configure JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}

*/
