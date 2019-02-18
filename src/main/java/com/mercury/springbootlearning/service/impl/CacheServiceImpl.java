package com.mercury.springbootlearning.service.impl;

import com.mercury.springbootlearning.dao.PersonRepository;
import com.mercury.springbootlearning.domain.Person;
import com.mercury.springbootlearning.service.ICacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * 使用spring-boot提供的默认缓存  ConcurrentMapCacheManager
 * 使用redis进行缓存数据
 *
 * @CachePut 缓存更新或新增的数据
 * @CacheEvict 清除缓存
 * @Cacheable 添加一个缓存
 * @CacheConfig(cacheNames = "people")
 */

@CacheConfig(cacheNames = "people")
@Slf4j
@Service("iCacheService")
public class CacheServiceImpl implements ICacheService {

    @Autowired
    private PersonRepository personRepository;


    @CachePut(value = "people", key = "'['+#person.id+']'")
    @Override
    public Person save(Person person) {
        Person result = personRepository.save(person);
        log.info("通过 @CachePut注解 为id key:{} 数据做了缓存.", result.getId());
        return result;
    }

    @CacheEvict(value = "people", key = "'['+#id+']'")
    @Override
    public void remove(Integer id) {
        log.info("通过@CacheEvict注解 删除id key:{}的数据缓存", id);
        // personRepository.delete(id);  // 直接删除数据库中数据
    }

    @Cacheable(value = "people", key = "'['+#person.id+']'")
    @Override
    public Person findOne(Person person) {

        Person result = personRepository.findOne(person.getId());
        log.info("通过 @Cacheable注解 为id key:{}的数据进行缓存", result.getId());
        return result;
    }
}
