package ru.job4j.server.controller;

import org.springframework.web.bind.annotation.*;
import ru.job4j.server.model.Passport;
import ru.job4j.server.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private PassportService service;

    public PassportController(PassportService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Passport> findAll() {
        return service.findAll();
    }

    @GetMapping("/expire")
    public List<Passport> findByExpireDate() {
        return service.findByExpireDate();
    }

    @GetMapping("/soonExpireDate")
    public List<Passport> findBySoonExpireDate() {
        return service.findBySoonExpireDate();
    }

    @GetMapping("/{id}")
    public Passport findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/series")
    public List<Passport> findBySeries(@RequestParam(name = "series") Integer series) {
        return this.service.findBySeries(series);
    }

    @PostMapping("/")
    public Passport create(@RequestBody Passport passport) {
        return service.create(passport);
    }

    @PutMapping("/")
    public void update(@RequestBody Passport passport) {
        service.update(passport);
    }

    @DeleteMapping("")
    public void delete(@RequestParam(name = "id") int id) {
        service.delete(id);
    }
}
