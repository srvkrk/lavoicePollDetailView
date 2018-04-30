package com.lavoice.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@Configuration
@EnableSpringHttpSession
public class SpringHttpSessionConfig {
	@Bean
    public MapSessionRepository sessionRepository() {
        return new MapSessionRepository();
    }
}
