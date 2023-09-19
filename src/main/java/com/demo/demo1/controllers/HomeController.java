package com.demo.demo1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
    @GetMapping("/test")
    public String test() {
        return "Test your World";
    }
}
