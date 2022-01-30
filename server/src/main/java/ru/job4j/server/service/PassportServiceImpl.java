package ru.job4j.server.service;

import org.springframework.stereotype.Service;
import ru.job4j.server.model.Passport;
import ru.job4j.server.repository.PassportRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PassportServiceImpl implements PassportService {

    private PassportRepository repository;

    public PassportServiceImpl(PassportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Passport> findAll() {
        return StreamSupport.stream(
                this.repository.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    @Override
    public Passport findById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Passport> findBySeries(int id) {
        return StreamSupport.stream(
                this.repository.findBySeries(id).spliterator(), false
        ).collect(Collectors.toList());
    }

    @Override
    public List<Passport> findByExpireDate() {
        return StreamSupport.stream(
                this.repository.findByExpireDate().spliterator(), false
        ).collect(Collectors.toList());
    }

    @Override
    public List<Passport> findBySoonExpireDate() {
        return StreamSupport.stream(
                this.repository.findBySoonExpireDate().spliterator(), false
        ).collect(Collectors.toList());
    }

    @Override
    public Passport create(Passport passport) {
        return this.repository.save(passport);
    }

    @Override
    public void update(Passport passport) {
        this.repository.save(passport);
    }

    @Override
    public void delete(int id) {
        Passport passport = new Passport();
        passport.setId(id);
        this.repository.delete(passport);
    }

}
