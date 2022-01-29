package ru.job4j.passport.controller;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.passport.model.Passport;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mfc")
public class MfcController {

    private static final String API = "http://localhost:8080/passport";

    private final RestTemplate restTemplate;

    public MfcController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/passport/")
    public List<Passport> findAllPassports() {
        return restTemplate.exchange(
                API + "/",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
    }

    @GetMapping("/passport/{id}")
    public Passport findPassportById(@PathVariable int id) {
        return restTemplate.exchange(
                API + "/{id}",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<Passport>() { }, id
        ).getBody();
    }

    @GetMapping("/passport")
    public List<Passport> findPassportBySeries(@RequestParam(name = "series") int series) {
        return restTemplate.exchange(
                API + "/series?series={series}",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() { }, series
        ).getBody();
    }

    @GetMapping("/passport/expire")
    public List<Passport> findPassportByExpireDate() {
        return restTemplate.exchange(
                API + "/expire",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
    }

    @GetMapping("/passport/soon_expire_date")
    public List<Passport> findPassportBySoonExpireDate() {
        return restTemplate.exchange(
                API + "/soon_expire_date",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
    }

    @PostMapping("/passport/")
    public ResponseEntity<Passport> create(@RequestBody Passport passport) {
        Passport rsl = restTemplate.postForObject(API + "/", passport, Passport.class);
        return new ResponseEntity<>(
                rsl,
                HttpStatus.CREATED
        );
    }

    @PutMapping("/passport/")
    public ResponseEntity<Void> update(@RequestBody Passport passport) {
        restTemplate.put(API + "/", passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/passport/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        restTemplate.delete(API + "?id={id}", id);
        return ResponseEntity.ok().build();
    }
}
