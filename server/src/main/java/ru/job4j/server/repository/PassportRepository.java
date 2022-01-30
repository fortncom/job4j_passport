package ru.job4j.server.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.server.model.Passport;

public interface PassportRepository extends CrudRepository<Passport, Integer> {

    Iterable<Passport> findBySeries(Integer series);

    @Query("select distinct p from passport p where p.expireDate < current_date")
    Iterable<Passport> findByExpireDate();

    @Query("select distinct p from passport p where p.expireDate "
            + "< current_date + 90 and p.expireDate > current_date")
    Iterable<Passport> findBySoonExpireDate();
}
