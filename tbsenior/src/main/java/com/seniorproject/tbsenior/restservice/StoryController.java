package com.seniorproject.tbsenior.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoryController {


    @GetMapping("/story/get")
    public Story getStory() {

    }

    @PutMapping("/story/put")
    public @ResponseBody newStory() {

    }

    @PostMapping("/story/post")
    public @ResponseBody update() {

    }

    @DeleteMapping("/story/delete")
    public @ResponseBody remove() {}

}