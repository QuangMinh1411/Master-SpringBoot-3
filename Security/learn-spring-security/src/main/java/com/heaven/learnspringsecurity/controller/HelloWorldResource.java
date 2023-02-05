package com.heaven.learnspringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class HelloWorldResource {
    @GetMapping("/hello-world")
    public String hello(){
        return "Hello world";
    }
}
