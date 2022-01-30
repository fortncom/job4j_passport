package ru.job4j.server.service;

import ru.job4j.server.model.Passport;

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
