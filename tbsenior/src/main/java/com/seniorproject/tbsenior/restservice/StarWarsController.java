package com.seniorproject.tbsenior.restservice;

import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping("/third-party")
public class StarWarsController {
    final String baseURL = "https://swapi.dev/api/";

    @GetMapping()
    public ResponseEntity<String> crawls() {
        try {
            String crawlURL = baseURL + "films/";
            RestTemplate restTemplate = new RestTemplate();
            URL url = new URL(crawlURL);

            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestProperty("Accept", "application/json");

            ResponseEntity<String> response = restTemplate.getForEntity(crawlURL, String.class);
            return response;
        } catch (Exception e) {
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/{ship}")
    public ResponseEntity<String> starships(@PathVariable("ship") String ship) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String search = baseURL + "/starships?search=" + ship;
            URL url = new URL(search);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestProperty("Accept", "application/json");

            ResponseEntity<String> response = restTemplate.getForEntity(search, String.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}