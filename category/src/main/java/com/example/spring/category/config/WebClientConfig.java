package com.example.spring.category.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.spring.category.client.JournalClient;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient journalWebClient(){
        return WebClient.builder()
                .baseUrl("http://journal")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public JournalClient journalClient(){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                                                            .builder(WebClientAdapter.forClient(journalWebClient()))
                                                            .build();
        return httpServiceProxyFactory.createClient(JournalClient.class);
    }
}
