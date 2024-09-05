package com.holokazh.retry_402_back.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pingController {

    @GetMapping("/ping")
    ResponseEntity<String> hello() {
        return ResponseEntity.ok("Pong");
    }

}
