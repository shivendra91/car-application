package com.fincity.carapplication.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class BeanConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
