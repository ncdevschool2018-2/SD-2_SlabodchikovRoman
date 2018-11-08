package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.RoleViewModel;

import java.util.List;

public interface RoleDataService {
    List<RoleViewModel> getAll();
    RoleViewModel getRoleByID(long id);
}
