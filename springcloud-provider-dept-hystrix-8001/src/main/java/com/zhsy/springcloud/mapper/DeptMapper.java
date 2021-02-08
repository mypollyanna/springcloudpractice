package com.zhsy.springcloud.mapper;

import com.zhsy.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
