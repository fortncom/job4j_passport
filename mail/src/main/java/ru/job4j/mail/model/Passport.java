package ru.job4j.mail.model;

import java.util.Date;
import java.util.Objects;

public class Passport {

    private int id;
    private int series;
    private int number;
    private Date expireDate;

    public static Passport of() {
        Passport passport = new Passport();
        return passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date releaseDate) {
        this.expireDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Passport passport = (Passport) o;
        return id == passport.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Passport{"
                + "id=" + id
                + ", series=" + series
                + ", number=" + number
                + ", expireDate=" + expireDate
                + '}';
    }
}
