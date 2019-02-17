package com.mercury.springbootlearning.controller;

import com.mercury.springbootlearning.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        User single = User.builder().id(1).name("张三").age(20).build();
        List<User> userList = new ArrayList<>();
        User user1 = User.builder().id(2).name("李四").age(21).build();
        User user2 = User.builder().id(3).name("王五").age(22).build();
        User user3 = User.builder().id(4).name("赵钱孙李").age(23).build();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", userList);
        log.info("single:{},userList:{}", single.toString(), userList.size());
        return "index";
    }
}
