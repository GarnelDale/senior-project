package com.seniorproject.tbsenior.restservice;

import java.util.concurrent.atomic.AtomicLong;
import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StoryController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/story")
    public Story getStory() {
        try {
            File file = ResourceUtils.getFile("classpath:data/story.txt");
            //File is found
            if(file.exists()) {
                //Read File Content
                try {
                    String content = new String(Files.readAllBytes(file.toPath()));
                    return new Story(counter.incrementAndGet(), content);
                } catch (IOException read) {
                    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }
            }
        }
        catch (FileNotFoundException fail) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new Story(counter.incrementAndGet(), "No Story Found");
    }

    @PutMapping("/story/put")
    public void newStory() {

    }

    @PostMapping("/story/post")
    public void update() {

    }

    @DeleteMapping("/story/delete")
    public void remove() {
//        Path path = Path.of("c:/temp/two.txt");
//        boolean success = Files.deleteIfExists(path);
    }

}