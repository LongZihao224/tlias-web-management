package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.service.DeptService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)  // 开启事务 一般在service层开启事务
    @Override
    public void delete(Integer id) {
        try {
            // 根据id删除部门
            deptMapper.delete(id);
            // 删除部门后，需要删除部门和员工的关系 empMapper
            empMapper.deleteByDeptId(id);

        } finally {
            // 新建日志
            DeptLog log = new DeptLog();
            log.setCreateTime(LocalDateTime.now());
            log.setDescription("执行了解散部门的操作，此次解散的是" + id + "部门");
            deptLogService.insert(log);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
