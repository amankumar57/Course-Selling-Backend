package com.scm.Service;

import java.util.List;

import com.scm.entity.Role;

public interface RoleService {
	
	List<Role> getAllRoles();

    Role getRoleById(Integer roleId);

    Role getRoleByRoleName(String roleName);

    Role createRole(Role role);

    Role updateRole(Role role);

    void deleteRole(Integer roleId);

}
