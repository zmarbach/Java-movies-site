package com.improving.pim;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/img/**")
                .addResourceLocations("classpath:/img/");

        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/");

        registry
                .addResourceHandler("/bootstrap/**")
                .addResourceLocations("classpath:/bootstrap/");
    }

}
