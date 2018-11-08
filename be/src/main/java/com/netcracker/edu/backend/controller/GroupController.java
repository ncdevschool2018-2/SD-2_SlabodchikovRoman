package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Group;
import com.netcracker.edu.backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/student_groups")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public Iterable<Group> getAllGroups(){
        return groupService.getAllGroups();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Group> getGroupById(@PathVariable(name="id")Long id){
        Optional<Group> group=groupService.getGroupById(id);
        if(group.isPresent()){
            return ResponseEntity.ok(group.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity deleteGroup(@PathVariable(name="id")Long id){
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.POST)
    public Group saveGroup(Group group){
        return groupService.saveGroup(group);
    }
}
