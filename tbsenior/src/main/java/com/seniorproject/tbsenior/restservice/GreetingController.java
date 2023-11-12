package com.seniorproject.tbsenior.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    public static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    GetMapping maps the given endpoint to the GET HTTP request type using the following function.
//    The @RequestParam allows for additional parameters to be passed through the URL to change the
//    return of the function.
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}