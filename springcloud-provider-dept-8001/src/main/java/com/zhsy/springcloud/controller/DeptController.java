package com.zhsy.springcloud.controller;

import com.zhsy.springcloud.pojo.Dept;
import com.zhsy.springcloud.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//提供restful服务
@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    @Resource
    private DiscoveryClient client;

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

    //注册进来的微服务，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>service:"+services);

        //得到一个具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (int i = 0; i < instances.size(); i++) {
            System.out.println(
                    instances.get(i).getHost()+"\t"+
                    instances.get(i).getPort()+"\t"+
                    instances.get(i).getUri()+"\t"+
                    instances.get(i).getServiceId()
            );
        }
        return instances;
    }
}
