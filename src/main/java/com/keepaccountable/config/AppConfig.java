package com.keepaccountable.config;

import com.mongodb.MongoClient;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {


    @NotNull
    @Value("${spring.data.mongodb.database}")
    private String mongoDbName;

    @NotNull
    @Value("${spring.data.mongodb.host}")
    private String mongoDbHost;


    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new MongoClient(mongoDbHost), mongoDbName);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
