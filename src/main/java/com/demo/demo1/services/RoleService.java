package com.demo.demo1.services;

import com.demo.demo1.models.Role;
import com.demo.demo1.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Iterable<Role> all() {
        return roleRepository.findAll();
    }
    public Optional<Role> getById(int id) {
        return roleRepository.findById(id);
    }
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
