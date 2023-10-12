package com.demo.demo1.services;

import com.demo.demo1.dto.UserDTO;
import com.demo.demo1.models.Role;
import com.demo.demo1.models.User;
import com.demo.demo1.repository.RoleRepository;
import com.demo.demo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Iterable<User> all() {
        return userRepository.findAll();
    }
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    public User save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());

        Role role = roleRepository.findById(userDTO.getRole_id()).orElse(null);
        user.setRole(role);
        return userRepository.save(user);
    }
    public User update(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());

        Role role = roleRepository.findById(userDTO.getRole_id()).orElse(null);
        user.setRole(role);
        return userRepository.save(user);
    }
}
