package com.sriyan.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/politician")
public class PoliticianController {
    @GetMapping("/getPolitician")
    ResponseEntity<String> getPolitician(){
        System.out.println("This is ***********");
        return  new ResponseEntity<>("Vishnu", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getLoggedInUser")
    ResponseEntity<String> getLoggedInUser(Principal principal){
        System.out.println("This is ***********");
        return  new ResponseEntity<>(principal.getName(), HttpStatus.ACCEPTED);
    }
}
