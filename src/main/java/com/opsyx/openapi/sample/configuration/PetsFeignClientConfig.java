package com.opsyx.openapi.sample.configuration;

import com.opsyx.openapi.sample.api.client.PetsApiClient;
import com.opsyx.openapi.sample.configuration.interceptors.BasicAuthInterceptor;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.okhttp.OkHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class PetsFeignClientConfig {

    @ConditionalOnProperty(name = "pets.api.mockEnabled", havingValue = "false", matchIfMissing = true)
    @Bean
    public PetsApiClient petsApiClient(@Value("pets.api.url") String url, BasicAuthInterceptor basicAuthInterceptor) {
        log.info("Pets FeignClientConfig");
        return Feign.builder().requestInterceptor(basicAuthInterceptor).client(new OkHttpClient()).encoder(new Encoder.Default()).decoder(new Decoder.Default()).target(PetsApiClient.class, url);
    }



}
