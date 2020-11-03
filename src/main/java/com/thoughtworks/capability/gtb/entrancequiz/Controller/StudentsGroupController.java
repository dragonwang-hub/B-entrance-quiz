package com.thoughtworks.capability.gtb.entrancequiz.Controller;


import com.thoughtworks.capability.gtb.entrancequiz.Dto.Students;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
// TODO GTB-知识点: - @RequestMapping的produces可以省略
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsGroupController {

    // TODO GTB-知识点: - 推荐使用构造器注入
    // TODO GTB-工程实践: - 违反了封装性，字段应该使用private
    @Autowired
    StudentsGroupService studentsGroupService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Students> getAllStudents() {
        return studentsGroupService.getAll();
    }

    // TODO GTB-知识点: - 违反Restful实践, url不合理
    @PostMapping(path = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody String name) {
        studentsGroupService.addStudent(name);
    }

    @GetMapping(path = "group")
    @ResponseStatus(HttpStatus.OK)
    // TODO GTB-知识点: - 违反Restful实践, 创建资源的请求应该使用POST
    // TODO GTB-工程实践: - 应该创建专门的对象来表示Group
    public Map<String, List<Students>> groupStudents() {
        return studentsGroupService.groupStudents();
    }
}
