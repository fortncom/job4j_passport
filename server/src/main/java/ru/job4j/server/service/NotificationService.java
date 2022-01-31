package ru.job4j.server.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.job4j.server.model.Passport;
import ru.job4j.server.repository.PassportRepository;

@Component
public class NotificationService {

    private final Gson gson = new GsonBuilder().create();

    @Autowired
    private KafkaTemplate<Integer, String> template;

    private PassportRepository repository;

    public NotificationService(PassportRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 3_000_000)
    public void scheduleTask() {
        Iterable<Passport> expiredPassports = repository.findByExpireDate();
        for (Passport passport : expiredPassports) {
            template.send("expiredPassport", gson.toJson(passport));
        }
    }
}
