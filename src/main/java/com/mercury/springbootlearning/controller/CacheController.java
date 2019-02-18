package com.mercury.springbootlearning.controller;


import com.mercury.springbootlearning.domain.Person;
import com.mercury.springbootlearning.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * spring-boot 缓存示例
 */

@RequestMapping("/cache")
@Controller
public class CacheController {

    @Autowired
    private ICacheService iCacheService;

    @RequestMapping("put")
    @ResponseBody
    public Person addCache(Person person) {
        return iCacheService.save(person);
    }

    @RequestMapping("add")
    @ResponseBody
    public Person addCacheByAnotherWay(@RequestParam(value = "id") Integer id) {
        Person person = new Person();
        person.setId(id);
        return iCacheService.findOne(person);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String remove(Integer id) {
        iCacheService.remove(id);
        return "delete cache ok.";
    }

}
