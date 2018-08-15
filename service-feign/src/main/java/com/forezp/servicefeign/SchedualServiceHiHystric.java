package com.forezp.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements ScheduleServiceHi {

    //每一个feign客户端的调用服务接口方法的实现方法，都是这个方法的断路器起作用时所调用的方法
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry , 断路器使用了" + name;
    }
}
