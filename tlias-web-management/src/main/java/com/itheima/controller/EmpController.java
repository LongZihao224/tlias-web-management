package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 分页查询员工信息
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询，参数：page = {}, pageSize = {}, name = {}, gender = {}, begin = {}" +
                " end = {}", page, pageSize, name, gender, begin, end);
        // 调用Service进行分页查询
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 批量删除员工信息
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除员工信息，参数：ids = {}", ids);
        // 调用Service进行批量删除
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 新增员工信息
     */
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("新增员工信息，参数：emp = {}", emp);
        // 调用Service进行新增
        empService.add(emp);
        return Result.success();
    }
}
