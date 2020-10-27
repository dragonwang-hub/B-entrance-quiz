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
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsGroupController {

    @Autowired
    StudentsGroupService studentsGroupService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Students> getAllStudents() {
        return studentsGroupService.getAll();
    }

    @PostMapping(path = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody String name) {
        studentsGroupService.addStudent(name);
    }

    @GetMapping(path = "group")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<Students>> groupStudents() {
        return studentsGroupService.groupStudents();
    }
}
