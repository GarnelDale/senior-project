package com.seniorproject.tbsenior.restservice;

import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import org.json.JSONObject;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/story")
public class StoryController {

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping()
    public ResponseEntity<Story> getStory() {
        try {
            File file = ResourceUtils.getFile("classpath:data/story.txt");
            //File is found
            if (file.exists()) {
                //Read File Content
                try {
                    String content = new String(Files.readAllBytes(file.toPath()));
                    return ResponseEntity.ok(new Story(content));
                } catch (IOException read) {
                    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }
            }
        } catch (FileNotFoundException fail) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Story("No story found"), HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PutMapping()
    public ResponseEntity newStory() {
        try {
            // Get the file
            File file = ResourceUtils.getFile("classpath:data");
            file = new File(file.getPath() + "/story.txt");
            // Create new file
            // if it does not exist
            if (!file.exists()) {
                file.createNewFile();
                return new ResponseEntity(HttpStatus.CREATED);
            }
            else
                return new ResponseEntity(HttpStatus.CONFLICT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PostMapping()
    public ResponseEntity update(@RequestBody String poem) {
        try {
            File file = ResourceUtils.getFile("classpath:data/story.txt");
            JSONObject reqObj = new JSONObject(poem);
            String story = reqObj.getString("story");
            //File is found
            if (file.exists()) {
                // Update the file
                if (story.length() == 0){
                    return new ResponseEntity(HttpStatus.CREATED);
                } else {
                    Files.write(file.toPath(), ("\n" + story).getBytes(), StandardOpenOption.APPEND);
                    return new ResponseEntity(HttpStatus.CREATED);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @DeleteMapping()
    public ResponseEntity remove() {
        try {
            File file = ResourceUtils.getFile("classpath:data/story.txt");
            if(file.delete())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

}