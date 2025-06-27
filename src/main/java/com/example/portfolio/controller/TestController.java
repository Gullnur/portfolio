package com.example.portfolio.controller;

import com.example.portfolio.service.TestScopedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestScopedService scopedService1;

    @Autowired
    private TestScopedService scopedService2;

    @GetMapping
    public String testScope() {
        return "prototype scope test edildi — konsola bax!!!!!!";
    }
}
