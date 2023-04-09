package com.example.bladebuilder.conf;

import com.example.bladebuilder.converter.UserConverter;
import com.example.bladebuilder.converter.UserResponseDTOConverter;
import com.example.bladebuilder.model.calculate.Knife;
import com.example.bladebuilder.model.calculate.Separator;
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
    public Separator getSeparator() {
        return new Separator();
    }

    @Bean
    public Knife getKnife() {
        return new Knife();
    }

}
