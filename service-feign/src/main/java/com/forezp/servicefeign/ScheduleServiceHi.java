package com.forezp.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi") //调用某个服务-服务名
public interface ScheduleServiceHi {

    //调用了服务的某个接口
    @RequestMapping(value = "/hi" , method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
