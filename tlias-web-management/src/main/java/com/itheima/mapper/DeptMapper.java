package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();
}
