package com.github.SBTraining.service.admin;

import com.github.SBTraining.dao.RoleDao;
import com.github.SBTraining.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private RoleDao dao;

    public List<Role> getAllRoles() {
        return dao.findAll();
    }

    public void addRole(Role role) {
        dao.save(role);
    }
}
