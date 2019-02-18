package com.mercury.springbootlearning.service.impl;

import com.mercury.springbootlearning.dao.PersonRepository;
import com.mercury.springbootlearning.domain.Person;
import com.mercury.springbootlearning.service.ITransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service("iTransactionService")
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private PersonRepository personRepository;

    // 使用spring framework提供的事务注解支持
    @Transactional(rollbackFor = IllegalArgumentException.class)
    @Override
    public Person savePersonWithRollback(Person person) {

        Person result = personRepository.save(person);
        log.info("TransactionServiceImpl:savePersonWithRollback save result:{}", result != null ? result.toString() : null);
        if ("mercury".equalsIgnoreCase(result.getName())) {
            throw new IllegalArgumentException("mercury数据已经存在,数据将进行回滚操作");
        }
        return result;
    }

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    @Override
    public Person savePersonWithoutRollback(Person person) {
        Person result = personRepository.save(person);
        log.info("TransactionServiceImpl:savePersonWithoutRollback save result:{}", result != null ? result.toString() : null);
        if ("mercury".equalsIgnoreCase(result.getName())) {
            throw new IllegalArgumentException("mercury数据已经存在,但数据不进行回滚操作");
        }
        return result;
    }
}
