package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")  // 拦截所有请求
public class AbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前逻辑");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("放行后逻辑");
    }
}
