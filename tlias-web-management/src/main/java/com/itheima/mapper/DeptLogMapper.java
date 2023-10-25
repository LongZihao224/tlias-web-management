package com.itheima.mapper;

import com.itheima.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    /**
     * 插入日志
     * @param log
     */
    @Insert("insert into dept_log(create_time, description) values(#{createTime},#{description})")
    void insert(DeptLog log);
}
