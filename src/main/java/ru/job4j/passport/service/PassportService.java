package ru.job4j.passport.service;

import ru.job4j.passport.model.Passport;

import java.util.List;

public interface PassportService {

    List<Passport> findAll();

    Passport findById(int id);

    List<Passport> findBySeries(int id);

    List<Passport> findByExpireDate();

    List<Passport> findBySoonExpireDate();

    Passport create(Passport passport);

    void update(Passport passport);

    void delete(int id);
}
