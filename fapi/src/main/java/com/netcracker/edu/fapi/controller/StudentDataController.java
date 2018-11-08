package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.StudentViewModel;
import com.netcracker.edu.fapi.service.StudentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba/students")
public class StudentDataController {
    private StudentDataService service;

    @Autowired
    public StudentDataController(StudentDataService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<StudentViewModel>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentViewModel> getStudentById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(service.getStudentById(Long.valueOf(id)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(name = "id") String id) {
        service.deleteStudent(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public StudentViewModel saveStudent(StudentViewModel student) {
        return service.saveStudent(student);
    }
}
