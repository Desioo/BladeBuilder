package com.example.bladebuilder.conf;

import com.example.bladebuilder.converter.MeasurementConverter;
import com.example.bladebuilder.converter.MeasurementDetailsConverter;
import com.example.bladebuilder.converter.UserConverter;
import com.example.bladebuilder.converter.UserResponseDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(getUserResponseDTOConverter());
        registry.addConverter(getUserConverter());
        registry.addConverter(getMeasurementConverter());

    }

    @Bean
    public UserResponseDTOConverter getUserResponseDTOConverter() {
        return new UserResponseDTOConverter();
    }

    @Bean
    public UserConverter getUserConverter() {
        return new UserConverter();
    }

    @Bean
    public MeasurementConverter getMeasurementConverter() {
        return new MeasurementConverter();
    }

    @Bean
    public MeasurementDetailsConverter getMeasurementDetailsConverter() {
        return new MeasurementDetailsConverter();
    }
}
