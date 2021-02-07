package com.zhsy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//不能放在主应用程序上下文的@SpringBootApplication中，否则将由所有的@RibbonClient共享，所以将其放在单独的、不重叠的包内
@Configuration
public class zhsyRule {
    @Bean
    public IRule myRule(){
        return new ZhsyRandomRule();
    }

}
