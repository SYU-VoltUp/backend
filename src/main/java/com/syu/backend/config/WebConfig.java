package com.syu.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : backend
 * @name : WebConfig
 * @date : 5/15/24 1:42 PM
 * @modifyed : $
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}
