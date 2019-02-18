package com.mercury.springbootlearning.controller;


import com.mercury.springbootlearning.dataobject.Student;
import com.mercury.springbootlearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mongo")
@Controller
public class MongoController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("save")
    @ResponseBody
    public Student save(@RequestParam(value = "name") String name,
                        @RequestParam(value = "id") String id,
                        @RequestParam(value = "age") Integer age) {
        Student student = new Student();
        student.setId(id);
        student.setAge(age);
        student.setName(name);
        Student result = studentRepository.save(student);
        System.out.println("mongodb save result:" + result.toString());
        return result;
    }

    @RequestMapping("findById")
    @ResponseBody
    public Student findOne(@RequestParam(value = "id") String id) {
        System.out.println("mongodb findById id:" + id);
        Student result = studentRepository.findOne(id);
        System.out.println("mongodb findOne result:" + result.toString());
        return result;
    }
}
