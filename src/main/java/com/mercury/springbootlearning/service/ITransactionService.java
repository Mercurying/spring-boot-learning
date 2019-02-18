package com.mercury.springbootlearning.service;

import com.mercury.springbootlearning.domain.Person;

public interface ITransactionService {

    Person savePersonWithRollback(Person person);

    Person savePersonWithoutRollback(Person person);
}
