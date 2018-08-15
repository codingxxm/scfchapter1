package com.forezp.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi" , fallback = SchedualServiceHiHystric.class) //调用某个服务-value为服务名 ,fallback为断路器起作用时调用的具体的实现类,接口里调了哪些方法，对应的实现方法即为断路器处理方法
public interface ScheduleServiceHi {

    //调用了服务的某个接口
    @RequestMapping(value = "/hi" , method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
