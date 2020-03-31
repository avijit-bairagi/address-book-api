package com.avijit.addressbook.common.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Configuration
    public class ApplicationConfig {

        @Bean
        public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper;
        }
    }
}
