package com.bjp.config;

import com.bjp.web.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebApplicationConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        //访问user开头才执行过滤器，query开头的不会执行过滤器
        bean.addUrlPatterns("/user/*");
        return bean;
    }
}
