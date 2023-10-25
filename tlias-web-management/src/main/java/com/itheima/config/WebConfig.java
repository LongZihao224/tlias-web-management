package com.itheima.config;

import com.itheima.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 * 1. 编写拦截器类，实现HandlerInterceptor接口
 * 2. 在拦截器类上，添加@Component注解，将拦截器类交给Spring容器管理
 * 4. 在拦截器类中，编写拦截器逻辑
 * 5. 在拦截器类中，编写拦截器放行逻辑
 * 6. 在拦截器类中，编写拦截器放行路径
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")  // 拦截所有请求
                .excludePathPatterns("/login");  // 放行登录请求
    }
}
