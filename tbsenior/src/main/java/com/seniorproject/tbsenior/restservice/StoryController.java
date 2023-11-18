package com.seniorproject.tbsenior.restservice;

import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    @PutMapping()
    public ResponseEntity newStory() {
        try {
            // Get the file
            File f = new File("classpath:data/story.txt");

            // Create new file
            // if it does not exist
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (Exception e) {
            System.err.println(e);
        }
        return new ResponseEntity<>(new Story("No story found"), HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public void update() {

    }

    @DeleteMapping()
    public ResponseEntity<Story> remove() {
//        Path path = Path.of("c:/temp/two.txt");
//        boolean success = Files.deleteIfExists(path);
        // create object of Path
//        Path path
//                = Paths.get("D:\\Work\\Test\\file1.txt");
//
//        // delete File
//        try {
//
//            Files.delete(path);
//        }
//        catch (IOException e) {
//
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return new ResponseEntity<>(new Story("No story found"), HttpStatus.NO_CONTENT);

    }

}