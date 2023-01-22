package com.lab.lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exception")
public class TestExceptionController {

    @GetMapping
    public void throwException(){
        int res = 2/0;
    }
}
