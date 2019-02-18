package com.mercury.springbootlearning.controller;

import com.mercury.springbootlearning.domain.Person;
import com.mercury.springbootlearning.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 测试事务的支持
 */
@RequestMapping("/transaction")
@Controller
public class TransactionController {

    @Autowired
    private ITransactionService iTransactionService;

    @RequestMapping(value = "rollback", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Person rollback(@RequestParam(value = "name") String name,
                           @RequestParam(value = "age") Integer age,
                           @RequestParam(value = "address") String address) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setAddress(address);
        Person saveResult = iTransactionService.savePersonWithRollback(person);
        return saveResult;
    }

    @RequestMapping("withRollback")
    @ResponseBody
    public Person withRollback(@RequestParam(value = "name") String name,
                               @RequestParam(value = "age") Integer age,
                               @RequestParam(value = "address") String address) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setAddress(address);
        return iTransactionService.savePersonWithoutRollback(person);
    }

}
