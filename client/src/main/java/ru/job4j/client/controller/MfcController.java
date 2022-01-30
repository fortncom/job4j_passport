package ru.job4j.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.client.model.Passport;

import java.util.List;

@RestController
@RequestMapping("/mfc")
public class MfcController {

    @Value("${urlToPassportRepository.api}")
    private String api;

    private final RestTemplate restTemplate;

    public MfcController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/passport/")
    public List<Passport> findAllPassports() {
        return restTemplate.exchange(
                api + "/",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
    }

    @GetMapping("/passport/{id}")
    public Passport findPassportById(@PathVariable int id) {
        return restTemplate.exchange(
                api + "/{id}",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<Passport>() { }, id
        ).getBody();
    }

    @GetMapping("/passport")
    public List<Passport> findPassportBySeries(@RequestParam(name = "series") int series) {
        return restTemplate.exchange(
                api + "/series?series={series}",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() { }, series
        ).getBody();
    }

    @GetMapping("/passport/expire")
    public List<Passport> findPassportByExpireDate() {
        return restTemplate.exchange(
                api + "/expire",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
    }

    @GetMapping("/passport/soonExpireDate")
    public List<Passport> findPassportBySoonExpireDate() {
        return restTemplate.exchange(
                api + "/soonExpireDate",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
    }

    @PostMapping("/passport/")
    public ResponseEntity<Passport> create(@RequestBody Passport passport) {
        Passport rsl = restTemplate.postForObject(api + "/", passport, Passport.class);
        return new ResponseEntity<>(
                rsl,
                HttpStatus.CREATED
        );
    }

    @PutMapping("/passport/")
    public ResponseEntity<Void> update(@RequestBody Passport passport) {
        restTemplate.put(api + "/", passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/passport/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        restTemplate.delete(api + "?id={id}", id);
        return ResponseEntity.ok().build();
    }
}
