package com.seniorproject.tbsenior.restservice;

import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClient;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping("/third-party")
public class StarWarsController {
    final String baseURL = "https://swapi.dev/api/";

    @GetMapping()
    public ResponseEntity<String> crawls() {
        try {
            // Room for improvement: make the random number of the call be here instead of on the ui to
            // reduce call time and size
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

    @CrossOrigin
    @GetMapping(path = "/{ship}")
    public ResponseEntity<String> starships(@PathVariable("ship") String ship) {
        try {
            RestClient restClient = RestClient.create(baseURL);
            ResponseEntity<String> response = restClient.get()
                    .uri("starships?search={ship}", ship)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(String.class);
            return response;
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}