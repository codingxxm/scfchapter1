package com.forezp.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.hystrix.FallbackHandler;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired //之前通过bean注解注入的实例
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")  //为该方法创建断路器功能，指定了fallbackMethod
    public String hiService(String name){
        //通过restTemplate来消费service-hi服务的“/hi”接口
        //
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi,"+name+",sorry error";
    }
}
