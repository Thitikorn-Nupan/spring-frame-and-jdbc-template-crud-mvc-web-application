package net.spring.mvc.coding.config;

import net.spring.mvc.coding.repository.CustomerRepository;
import net.spring.mvc.coding.service.CustomerServiceRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:information-database/info.properties")
public class ConfigApp {

    @Value("${info.jdbc.driver}")
    private String driver;
    @Value("${info.jdbc.url}")
    private  String url;
    @Value("${info.jdbc.username}")
    private  String username;
    @Value("${info.jdbc.password}")
    private  String password;


    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    public CustomerRepository customerRepository() {
        /* it works like to set construct of CustomerServiceRepo class */
        CustomerServiceRepo customerServiceRepo = new CustomerServiceRepo(dataSource());
        return customerServiceRepo;
    }

}
