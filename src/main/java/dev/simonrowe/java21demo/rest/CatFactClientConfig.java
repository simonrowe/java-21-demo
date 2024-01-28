package dev.simonrowe.java21demo.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class CatFactClientConfig {

    @Bean
    RestClient restClient(RestClient.Builder builder) {
        return builder.requestFactory(new JdkClientHttpRequestFactory())
            .build();
    }

    @Bean
    CatFactClient catFactClient(RestClient restClient) {
        return HttpServiceProxyFactory.builder()
            .exchangeAdapter(RestClientAdapter.create(restClient))
            .build()
            .createClient(CatFactClient.class);
    }
}
