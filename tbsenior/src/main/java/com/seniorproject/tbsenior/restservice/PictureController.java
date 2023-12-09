package com.seniorproject.tbsenior.restservice;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.apache.commons.io.*;
import org.json.JSONObject;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping("/picture")
public class PictureController {
    //Privates to enable any filename for upload and download
    private String directory = "classpath:data/";
    private String filename = "spicy_bounce.gif";

    //From https://www.baeldung.com/spring-controller-return-image-file
    @GetMapping(produces = MediaType.IMAGE_GIF_VALUE)
    public @ResponseBody byte[] getImage() throws IOException {
        InputStream in = getClass().getClassLoader()
                .getResourceAsStream("data/" + filename);
        try {
            byte[] image = IOUtils.toByteArray(in);
            in.close();
            return image;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
            filename = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(directory, filename);
            Files.write(fileNameAndPath, file.getBytes());
            return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity deleteImage() {
        try {
            File file = ResourceUtils.getFile(directory + filename);
            if(file.delete()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            else
                return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}