package com.forezp.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired //之前通过bean注解注入的实例
    RestTemplate restTemplate;

    public String hiService(String name){
        //通过restTemplate来消费service-hi服务的“/hi”接口
        //
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
}
