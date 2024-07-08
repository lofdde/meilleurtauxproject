package com.meilleurtaux.communesproject.infrastructure.configuration;

import com.meilleurtaux.communesproject.infrastructure.error.ApiResponseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ApiResponseHandler());
        return restTemplate;
    }

}
