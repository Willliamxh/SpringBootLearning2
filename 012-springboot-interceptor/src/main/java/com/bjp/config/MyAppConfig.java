package com.bjp.config;

import com.bjp.web.LoginInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//WebMvcConfigurer这个接口和springmvc的很多配置相关，
// 我们这边相当于把xml里面写的东西移动到了这边来
public class MyAppConfig implements WebMvcConfigurer {
    //添加拦截器对象，注入到容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器对象
        HandlerInterceptor interceptor=new LoginInterceptor();
        //指定拦截到请求url地址
        String path[]={"/user/**"};
        //指定不拦截的地址
        String excludePath[]={"/user/login"};

        registry.addInterceptor(interceptor)
        .addPathPatterns(path)
        .excludePathPatterns(excludePath);
    }
}
