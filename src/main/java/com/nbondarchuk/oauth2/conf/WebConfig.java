package com.nbondarchuk.oauth2.conf;

import com.nbondarchuk.oauth2.endpoint.WelcomeEndpoint;
import com.nbondarchuk.oauth2.endpoint.exception.AccessDeniedExceptionMapper;
import com.nbondarchuk.oauth2.endpoint.exception.UncaughtExceptionMapper;
import com.nbondarchuk.oauth2.endpoint.exception.WebApplicationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Nikolay Bondarchuk
 * @since 2020-04-04
 */
@Configuration
public class WebConfig extends ResourceConfig {

    @PostConstruct
    public void init() {
        registerEndpoints();
        registerExceptionMappers();
    }

    @Bean
    public WelcomeEndpoint welcomeEndpoint() {
        return new WelcomeEndpoint();
    }

    private void registerEndpoints() {
        register(WelcomeEndpoint.class);
    }

    private void registerExceptionMappers() {
        register(UncaughtExceptionMapper.class);
        register(AccessDeniedExceptionMapper.class);
        register(WebApplicationExceptionMapper.class);
    }
}
