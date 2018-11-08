package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.GroupViewModel;
import com.netcracker.edu.fapi.service.GroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba/student_groups")
public class GroupDataController {
    private GroupDataService service;

    @Autowired
    public GroupDataController(GroupDataService service) {
        this.service = service;
    }

    @RequestMapping(value="",method= RequestMethod.GET)
    public ResponseEntity<List<GroupViewModel>> getAllGroups(){
        return ResponseEntity.ok(service.getAllGroups());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteGroup(@PathVariable(name="id")String id){
        service.deleteGroup(Long.valueOf(id));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<GroupViewModel> getGroupById(@PathVariable(name="id")String id){
        return ResponseEntity.ok(service.getGroupById(Long.valueOf(id)));
    }

    @RequestMapping(method=RequestMethod.POST)
    public GroupViewModel saveGroup(GroupViewModel group){
        return service.saveGroup(group);
    }
}
