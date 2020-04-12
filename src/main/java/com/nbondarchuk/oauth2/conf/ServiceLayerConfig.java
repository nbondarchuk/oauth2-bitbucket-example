package com.nbondarchuk.oauth2.conf;

import com.nbondarchuk.oauth2.service.UserService;
import com.nbondarchuk.oauth2.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nikolay Bondarchuk
 * @since 2020-04-05
 */
@Configuration
public class ServiceLayerConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
