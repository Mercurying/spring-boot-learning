package com.mercury.springbootlearning.service;

import com.mercury.springbootlearning.domain.Person;

public interface ICacheService {

    Person save(Person person);

    void remove(Integer id);

    Person findOne(Person person);
}
