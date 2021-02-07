package com.zhsy.springcloud.controller;

import com.zhsy.springcloud.pojo.Dept;
import com.zhsy.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptConsumerController {
    //消费者不应该有service层
    //RestTemplate供我们直接调用就可以了，注册到spring中

    @Resource
    private DeptClientService deptClientService = null;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept queryAll(@PathVariable("id") Long id){
        return this.deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept){
        return this.deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.deptClientService.queryAll();
    }
}