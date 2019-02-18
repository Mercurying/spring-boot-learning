package com.mercury.springbootlearning.dao;

import com.mercury.springbootlearning.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param(value = "name") String name,
                                   @Param(value = "address") String address);

    // 在实体Person中定义了查询sql语句
    List<Person> withNameAndAddressNamedQuery(String name, String address);


    // restful api形式暴露
//    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
//    Person findByNameStartsWith(@Param(value = "name") String name);
}
