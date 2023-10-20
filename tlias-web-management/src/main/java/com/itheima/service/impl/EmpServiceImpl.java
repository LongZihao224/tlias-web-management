package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.service.EmpService;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender,
                          LocalDate begin,
                          LocalDate end) {
        // 设置PageHelper分页参数
        PageHelper.startPage(page, pageSize);
        // 执行查询
        List<Emp> list = empMapper.list(name, gender, begin, end);
        // 将结果转换为Page
        Page<Emp> p = (Page<Emp>) list;
        // 封装PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }
}
