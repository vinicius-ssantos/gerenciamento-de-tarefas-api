package com.viniciussantos.config;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {

//    @Bean
//    @ServiceConnection
//    @RestartScope
//    MySQLContainer<?> mySQLContainer(){return new MySQLContainer<>("mysql:8.0.33");}

    @Bean
    @ServiceConnection
    @RestartScope
    PostgreSQLContainer<?> postgreSQLContainer(){
        return new PostgreSQLContainer<>("postgres:15-alpine");
    }

}
