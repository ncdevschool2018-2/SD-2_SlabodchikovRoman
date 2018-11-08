package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.RoleViewModel;
import com.netcracker.edu.fapi.service.RoleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba/roles")
public class RoleDataController {
    private RoleDataService roleDataService;

    @Autowired
    public RoleDataController(RoleDataService roleDataService) {
        this.roleDataService = roleDataService;
    }

    @RequestMapping("")
    public ResponseEntity<List<RoleViewModel>> getAllRoles() {
        return ResponseEntity.ok(roleDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoleViewModel> getRoleById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(roleDataService.getRoleByID(Long.valueOf(id)));
    }

}
