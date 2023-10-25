package com.itheima.filter;

import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

@Slf4j
//@WebFilter(urlPatterns = "/*")  // 拦截所有请求
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取请求url
        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        // 判断请求url中是否包含login，如果包含，说明是登录请求，直接放行
        if (url.contains("login")) {
            log.info("登录请求，放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 获取请求头中的令牌
        String token = ((HttpServletRequest) servletRequest).getHeader("token");
        // 判断令牌是否存在，如果不存在，说明未登录，返回错误信息
        if (!StringUtils.hasLength(token)) {
            log.info("未登录，返回错误信息");
            Result error = Result.error("NOT_LOGIN");
            // 将error转化为json，使用fastjson
            String json = com.alibaba.fastjson.JSONObject.toJSONString(error);
            ((HttpServletResponse) servletResponse).getWriter().write(json);
            return;
        }
        // 解析token，如果解析失败，说明令牌不正确，返回错误信息
        try {
            JwtUtils.parseJwtToken(token);
        } catch (Exception e) {
            log.info("令牌不正确，返回错误信息");
            Result error = Result.error("NOT_LOGIN");
            // 将error转化为json，使用fastjson
            String json = com.alibaba.fastjson.JSONObject.toJSONString(error);
            ((HttpServletResponse) servletResponse).getWriter().write(json);
            return;
        }
        // 放行
        log.info("令牌正确，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
