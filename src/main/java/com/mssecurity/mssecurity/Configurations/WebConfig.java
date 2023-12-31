package com.mssecurity.mssecurity.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mssecurity.mssecurity.Interceptors.SecurityInterceptor;

/**
 * WebConfig
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private SecurityInterceptor securityInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(securityInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/security/**");
    ; // Asegúrate de que las rutas sean las correctas
  }
}