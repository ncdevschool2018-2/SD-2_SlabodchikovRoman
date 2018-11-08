package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Proffessor;
import com.netcracker.edu.backend.service.ProffessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/proffessors")
public class ProffessorController {

    private ProffessorService proffessorService;

    @Autowired
    public ProffessorController(ProffessorService proffessorService) {
        this.proffessorService = proffessorService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Proffessor> getAllProffessors() {
        return proffessorService.getAllProffessors();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Proffessor saveProffessor(@RequestBody Proffessor proffessor) {
        return proffessorService.saveProffessor(proffessor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Proffessor> getProffessorById(@PathVariable(name = "id") Long id) {
        Optional<Proffessor> proffessor = proffessorService.getProffessorByID(id);
        if (proffessor.isPresent()) {
            return ResponseEntity.ok(proffessor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProffessor(@PathVariable(name="id") Long id){
        proffessorService.deleteProffessor(id);
        return ResponseEntity.noContent().build();
    }
}
