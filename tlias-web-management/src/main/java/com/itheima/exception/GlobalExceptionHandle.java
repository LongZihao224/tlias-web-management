package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * 1. 编写异常处理类，使用@ControllerAdvice和@ExceptionHandler注解
 * 2. 在异常处理类中，编写异常处理方法
 * 3. 在异常处理方法上，编写异常处理逻辑
 * 4. 在异常处理方法上，使用@ResponseBody注解，将异常处理结果响应给客户端
 * 5. 在异常处理方法上，使用@ExceptionHandler注解，指定要处理的异常类型
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class) // 捕获所有异常
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}
