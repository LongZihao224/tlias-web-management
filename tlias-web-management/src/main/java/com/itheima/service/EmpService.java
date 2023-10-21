package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 实现分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender,
                  LocalDate begin,
                  LocalDate end);

    /**
     * 批量删除员工信息
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工信息
     * @param emp
     */
    void add(Emp emp);
}
