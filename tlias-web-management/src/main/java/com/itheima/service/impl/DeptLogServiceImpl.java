package com.itheima.service.impl;


import com.itheima.mapper.DeptLogMapper;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    DeptLogMapper deptLogMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(DeptLog log) {
        // 调用mapper
        deptLogMapper.insert(log);
    }
}
