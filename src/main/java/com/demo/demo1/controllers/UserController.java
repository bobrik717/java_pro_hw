package com.demo.demo1.controllers;

import com.demo.demo1.dto.UserDTO;
import com.demo.demo1.models.User;
import com.demo.demo1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("")
    public ResponseEntity<String> index() {
        Iterable<User> users = service.all();
        return new ResponseEntity<>(users.toString(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> show(@PathVariable int id) {
        Optional<User> user = service.getById(id);
        return new ResponseEntity<>(user.get().toString(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserDTO model) {
        User user = service.save(model);
        return new ResponseEntity<>(user.toString(), HttpStatus.OK);
    }
    @PutMapping("/save")
    public ResponseEntity<String> update(@RequestBody UserDTO model) {
        User user = service.update(model);
        return new ResponseEntity<>(user.toString(), HttpStatus.OK);
    }
}
