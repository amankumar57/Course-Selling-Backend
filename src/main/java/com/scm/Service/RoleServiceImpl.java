package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Role;
import com.scm.repositery.RoleRepositery;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepositery roleRepo;

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role getRoleById(Integer roleId) {
        Optional<Role> role = roleRepo.findById(roleId);
        return role.orElse(null);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepo.findByRoleName(roleName);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void deleteRole(Integer roleId) {
        roleRepo.deleteById(roleId);
    }
}