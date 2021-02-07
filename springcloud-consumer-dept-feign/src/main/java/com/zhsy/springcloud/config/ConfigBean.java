package com.zhsy.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //相当于spring里的applicationContext.xml
public class ConfigBean {
    //配置负载均衡
    @Bean
    @LoadBalanced //ribbon
    //IRule
    //AvailabilityFilteringRule: 先会过滤掉跳闸、访问故障的服务，对剩下的进行轮询
    //RandomRule:随机
    //RetryRule:先按照轮询获取服务，如果服务获得失败，则会在指定的时间内进行重试
    //RoundRobinRule：轮询，默认
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
