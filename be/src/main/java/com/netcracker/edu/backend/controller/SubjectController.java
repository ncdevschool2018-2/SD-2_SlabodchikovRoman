package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Subject;
import com.netcracker.edu.backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private SubjectService subjectService;

    @Autowired

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public Iterable<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @RequestMapping(method=RequestMethod.POST)
    public Subject saveSubject(@RequestBody Subject subject){
        return subjectService.saveSubject(subject);
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ResponseEntity<Subject> getSubjectById(@PathVariable(name="id")Long id){
        Optional<Subject> subject=subjectService.getSubjectById(id);
        if(subject.isPresent()){
            return ResponseEntity.ok(subject.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public ResponseEntity deleteSubject(@PathVariable(name="id")Long id){
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
