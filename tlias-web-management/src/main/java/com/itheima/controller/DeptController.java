package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itheima.service.DeptService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {
    // 注入DeptService
    @Autowired
    private DeptService deptService;
    /**
     * 查询所有部门信息
     * @return Result
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET) 更方便的注解如下👇
    @GetMapping
    public Result list() {
        log.info("查询所有部门信息");
        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门信息
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门信息", id);
        // 调用service删除部门数据
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 接受部门名，格式是json，新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门", dept);
        // 调用service新增部门数据
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 接受部门id，新部门名，修改部门
     * 新部门的id和部门名都用json传输
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门", dept);
        System.out.println(dept);
        // 调用service修改部门数据
        deptService.update(dept);
        return Result.success();
    }
}
