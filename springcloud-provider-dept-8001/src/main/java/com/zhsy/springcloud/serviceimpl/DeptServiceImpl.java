package com.zhsy.springcloud.serviceimpl;

import com.zhsy.springcloud.mapper.DeptMapper;
import com.zhsy.springcloud.pojo.Dept;
import com.zhsy.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptMapper.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
