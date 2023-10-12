package com.demo.demo1.controllers;

import com.demo.demo1.models.Role;
import com.demo.demo1.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService service;
    @GetMapping("")
    public ResponseEntity<String> index() {
        Iterable<Role> roles = service.all();
        return new ResponseEntity<>(roles.toString(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> show(@PathVariable int id) {
        Optional<Role> role = service.getById(id);
        return new ResponseEntity<>(role.get().toString(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Role model) {
        Role role = service.save(model);
        return new ResponseEntity<>(role.toString(), HttpStatus.OK);
    }
    @PutMapping("/save")
    public ResponseEntity<String> update(@RequestBody Role model) {
        Role role = service.save(model);
        return new ResponseEntity<>(role.toString(), HttpStatus.OK);
    }
}
