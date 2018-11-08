package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.ProffessorViewModel;
import com.netcracker.edu.fapi.service.ProffessorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba/proffessors")
public class ProffessorDataController {

    private ProffessorDataService service;

    @Autowired
    public ProffessorDataController(ProffessorDataService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ProffessorViewModel>> getAllProffessors() {
        return ResponseEntity.ok(service.getAllProffessors());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProffessorViewModel> getProffessorById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(service.getProffessorById(Long.valueOf(id)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProffessor(@PathVariable(name = "id") String id) {
        service.deleteProffessor(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProffessorViewModel saveSubject(ProffessorViewModel proffessor) {
        return service.saveProffessor(proffessor);
    }
}
