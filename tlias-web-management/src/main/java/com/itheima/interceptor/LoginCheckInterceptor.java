package com.itheima.interceptor;

import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override  // 目标资源方法执行前执行，返回true放行，返回false拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求url
        String url = request.getRequestURI();
        // 判断请求url中是否包含login，如果包含，说明是登录请求，直接放行
        if (url.contains("login")) {
            log.info("登录请求，放行");
            return true;
        }
        // 获取请求头中的令牌
        String token = request.getHeader("token");
        // 判断令牌是否存在，如果不存在，说明未登录，返回错误信息
        if (!StringUtils.hasLength(token)) {
            log.info("未登录，返回错误信息");
            Result error = Result.error("NOT_LOGIN");
            // 将error转化为json，使用fastjson
            String json = com.alibaba.fastjson.JSONObject.toJSONString(error);
            response.getWriter().write(json);
            return false;
        }
        // 解析token，如果解析失败，说明令牌不正确，返回错误信息
        try {
            JwtUtils.parseJwtToken(token);
        } catch (Exception e) {
            log.info("令牌不正确，返回错误信息");
            Result error = Result.error("NOT_LOGIN");
            // 将error转化为json，使用fastjson
            String json = com.alibaba.fastjson.JSONObject.toJSONString(error);
            response.getWriter().write(json);
            return false;
        }
        // 放行
        log.info("令牌正确，放行");
        return true;
    }

    @Override  // 目标资源方法执行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle执行了");
    }

    @Override  // 页面响应后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion执行了");
    }
}
