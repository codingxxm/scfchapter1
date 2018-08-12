package com.forezp.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
