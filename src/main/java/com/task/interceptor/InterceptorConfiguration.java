package com.task.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author licunzhi
 * @desc 添加自定义拦截
 * @date 2018-03-13
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    private static final String[] excludePatterns = {"/login", "/api/login","/api/regist", "/login.html", "/error/**"
            ,"/css/**","/layui/**", "/js/**","/fonts/**","/images/**"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).excludePathPatterns(excludePatterns);
    }

    @Override
    //需要告知系统，这是要被当成静态文件的！
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //第一个方法设置访问路径前缀，第二个方法设置资源路径
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
