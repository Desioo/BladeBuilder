package com.example.bladebuilder.conf;

import com.example.bladebuilder.converter.entity.MeasurementConverter;
import com.example.bladebuilder.converter.request.OptionalOrderByIdConverter;
import com.example.bladebuilder.converter.request.OptionalUserConverter;
import com.example.bladebuilder.converter.request.OrderConverter;
import com.example.bladebuilder.converter.request.OrderListConverter;
import com.example.bladebuilder.converter.response.MeasurementDetailsConverter;
import com.example.bladebuilder.converter.response.MeasurementResponseDTOConverter;
import com.example.bladebuilder.converter.response.MeasurementWithCalculationsConverter;
import com.example.bladebuilder.converter.response.UserResponseDTOConverter;
import com.example.bladebuilder.exception.GlobalExceptionHandler;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setCacheSeconds(0);
        messageSource.setBasenames("classpath:messages", "classpath:messages_pl");
        return messageSource;
    }

    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(getUserResponseDTOConverter());
        registry.addConverter(getUserConverter());
        registry.addConverter(getMeasurementConverter());
        registry.addConverter(getOrderConverter());
        registry.addConverter(getOrderListConverter());
        registry.addConverter(getOptionalOrderByIdConverter());
        registry.addConverter(getMeasurementWithCalculationsConverter());
        registry.addConverter(getMeasurementResponseDTOConverter());
        registry.addConverter(getMeasurementDetailsConverter());

    }

    @Bean
    public UserResponseDTOConverter getUserResponseDTOConverter() {
        return new UserResponseDTOConverter();
    }

    @Bean
    public OptionalUserConverter getUserConverter() {
        return new OptionalUserConverter();
    }

    @Bean
    public MeasurementConverter getMeasurementConverter() {
        return new MeasurementConverter();
    }

    @Bean
    public MeasurementDetailsConverter getMeasurementDetailsConverter() {
        return new MeasurementDetailsConverter();
    }

    @Bean
    public OrderConverter getOrderConverter() {
        return new OrderConverter();
    }

    @Bean
    public OrderListConverter getOrderListConverter() {
        return new OrderListConverter();
    }

    @Bean
    public OptionalOrderByIdConverter getOptionalOrderByIdConverter() {
        return new OptionalOrderByIdConverter();
    }

    @Bean
    public MeasurementWithCalculationsConverter getMeasurementWithCalculationsConverter() {
        return new MeasurementWithCalculationsConverter();
    }

    @Bean
    public MeasurementResponseDTOConverter getMeasurementResponseDTOConverter(){
        return new MeasurementResponseDTOConverter();
    }

    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
