package com.mercury.springbootlearning.controller;

import com.mercury.springbootlearning.dao.PersonRepository;
import com.mercury.springbootlearning.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/jpa")
@RestController
public class JpaController {

    @Autowired
    private PersonRepository personRepository;

    /*测试保存*/
    @GetMapping(value = {"save"})
    public Person save() {
        Person wang = new Person("laoWang", 25, "China");
        log.info("JpaController:save result:{}", wang.toString());
        return personRepository.save(wang);
    }

    @GetMapping(value = {"find"})
    public List<Person> find(String name) {
        List<Person> list = personRepository.findByName(name);
        log.info("JpaController:find params:{},result:{}", name, list.size());
        return list;
    }

    @GetMapping(value = {"findByNameAndAddress"})
    public Person findByNameAndAddress(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "address") String address) {
        Person result = personRepository.findByNameAndAddress(name, address);
        log.info("JpaController:findByNameAndAddress params-name:{},params-address:{},result:{}", name, address, result.toString());
        return result;
    }

    @GetMapping(value = {"list"})
    public List<Person> list(@RequestParam(value = "name") String name,
                             @RequestParam(value = "address") String address) {
        List<Person> list = personRepository.withNameAndAddressNamedQuery(name, address);
        log.info("JpaController:list params-name:{},params-address:{},result:{}", name, address, list.size());
        return list;
    }

    @GetMapping(value = {"queryPersonByNameAndAddress"})
    public Person queryPeronByNameAndAddress(@RequestParam(value = "name") String name,
                                             @RequestParam(value = "address") String address) {
        Person result = personRepository.withNameAndAddressQuery(name, address);
        log.info("JpaController:queryPeronByNameAndAddress params-name:{},params-address:{},result:{}", name, address, result.toString());
        return result;
    }

    @GetMapping(value = {"sort"})
    public List<Person> findAll() {
        List<Person> list = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return list;
    }

    @GetMapping(value = {"page"})
    public Page<Person> page(@RequestParam(value = "index", defaultValue = "1", required = false) int index,
                             @RequestParam(value = "size", defaultValue = "2", required = false) int size,
                             @RequestParam(value = "properties") String properties) {
        return personRepository.findAll(new PageRequest(index, size, Sort.Direction.DESC, properties));
    }
}
