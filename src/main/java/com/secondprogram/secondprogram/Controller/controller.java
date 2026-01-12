package com.secondprogram.secondprogram.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    
    @RequestMapping("path")
    public String display() {
        return "Hello World!";
    }

    @GetMapping("greet")
    public String greet() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("submit")
    public String submit() {
        return "Data submitted successfully!";
    }   

    @DeleteMapping("remove")
    public String remove() {    
        return "Data removed successfully!";
    }   

    @PutMapping("update")
    public String update() {    
        return "Data updated successfully!";
    }   
}
