package com.mercury.springbootlearning.repository;

import com.mercury.springbootlearning.dataobject.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
