package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Student;
import com.netcracker.edu.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable(name="id")Long id){
        Optional<Student> student=studentService.getStudentById(id);
        if(student.isPresent()){
            return ResponseEntity.ok(student.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable(name="id")Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
}
