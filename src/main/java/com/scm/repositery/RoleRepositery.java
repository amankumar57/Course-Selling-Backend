package com.scm.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.Role;

public interface RoleRepositery extends JpaRepository<Role, Integer>{

	// Custom query if needed
    Role findByRoleName(String roleName);
}
