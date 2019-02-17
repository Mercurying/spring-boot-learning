package com.mercury.springbootlearning.controller;

import com.mercury.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test spring-autoconfigure
 */
@RequestMapping("/auto")
@RestController
public class AutoConfigurationController {

    // 此处注入时idea提示错误 可以修改提示为警告级别
    @Autowired
    private HelloService helloService;

    @GetMapping(value = {"hello"})
    public String hello() {
        return helloService.sayHello();
    }

}
