package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp")
//    Long count();
    /**
     * 员工信息查询
     */
//    @Select("select * from emp")
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工信息
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工信息
     * @param emp
     */
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void add(Emp emp);
}
