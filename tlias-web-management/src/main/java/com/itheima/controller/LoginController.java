package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录，参数：emp = {}", emp);
        // 调用Service进行登录
        Emp e = empService.login(emp);
        // 登录成功，生成令牌，下发令牌
        if (e != null) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());
            // 生成令牌
            String jwt = JwtUtils.createJwtToken(claims);
            // 下发令牌
            return Result.success(jwt);
        }
        // 登录失败，返回错误信息
        return Result.error("用户名或密码错误");
    }
}
