package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.SubjectViewModel;
import com.netcracker.edu.fapi.service.SubjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba/subjects")
public class SubjectDataController {

    private SubjectDataService service;

    @Autowired
    public SubjectDataController(SubjectDataService service) {
        this.service = service;
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public ResponseEntity<List<SubjectViewModel>> getAllSubjects(){
        return ResponseEntity.ok(service.getAllSubjects());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteSubject(@PathVariable(name="id")String id){
        service.deleteSubject(Long.valueOf(id));;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<SubjectViewModel> getSubjectById(@PathVariable(name="id")String id){
        return ResponseEntity.ok(service.getSubjectById(Long.valueOf(id)));
    }

    @RequestMapping(method=RequestMethod.POST)
    public SubjectViewModel saveSubject(SubjectViewModel subject){
        return service.saveSubject(subject);
    }
}
