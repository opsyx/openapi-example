package com.opsyx.openapi.sample.configuration.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class BasicAuthInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // TODO put interceptor code
        requestTemplate.header("authentication", "Basic: base64encodedStringhere");
    }
}
