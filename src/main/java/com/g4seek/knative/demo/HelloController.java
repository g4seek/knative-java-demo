package com.g4seek.knative.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${TARGET:World}")
    String target;

    @GetMapping("/")
    String hello() {
        return "Hello " + target + "!";
    }
}
