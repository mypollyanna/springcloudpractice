package com.zhsy.springcloud.controller;

import com.zhsy.springcloud.pojo.Dept;
import com.zhsy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//提供restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(Dept dept){
        return deptService.queryAll();
    }
}
