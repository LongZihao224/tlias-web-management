package com.itheima.service;

import com.itheima.pojo.PageBean;

import java.time.LocalDate;

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
}
