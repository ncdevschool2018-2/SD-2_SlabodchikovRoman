package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.GroupViewModel;

import java.util.List;

public interface GroupDataService {
    GroupViewModel saveGroup(GroupViewModel group);
    GroupViewModel getGroupById(Long id);
    List<GroupViewModel> getAllGroups();
    void deleteGroup(Long id);
}
