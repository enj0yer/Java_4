package ru.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.nio.file.Paths;

@Configuration
@EnableJdbcRepositories("ru.repositories")
public class ConnectionCfg extends AbstractJdbcConfiguration {

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUsername("sa");
        ds.setPassword("");
        ds.setUrl("jdbc:h2:" + Paths.get("C:\\Users\\Kulag\\Test"));

        return ds;
    }

    @Bean
    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}


