package com.github.SBTraining.dao;

import com.github.SBTraining.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {
}
