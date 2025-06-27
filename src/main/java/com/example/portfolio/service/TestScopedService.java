package com.example.portfolio.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class TestScopedService {

    public TestScopedService() {
        System.out.println("yeni TestScopedService yaradildi");
    }

    @PostConstruct
    public void init() {
        System.out.println("TestScopedService init() cagirildi");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("TestScopedService destroy() cagirildi");
    }
}
