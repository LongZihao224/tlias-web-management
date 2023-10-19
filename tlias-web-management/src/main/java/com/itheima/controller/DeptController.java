package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.service.DeptService;

import java.util.List;

@RestController
@Slf4j
public class DeptController {
    // 注入DeptService
    @Autowired
    private DeptService deptService;
    /**
     * 查询所有部门信息
     * @return Result
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET) 更方便的注解如下👇
    @GetMapping("/depts")
    public Result list() {
        log.info("查询所有部门信息");
        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
}
