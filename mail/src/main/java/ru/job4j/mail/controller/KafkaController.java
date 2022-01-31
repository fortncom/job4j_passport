package ru.job4j.mail.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.job4j.mail.model.Passport;

@Component
public class KafkaController {

    private final Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"expiredPassport"})
    public void listenStatistic(ConsumerRecord<Integer, String> input) {
        Passport passport = gson.fromJson(input.value().replace(
                "Passport", ""), Passport.class);
        System.out.printf("\n Паспорт с серией %d и номером %d просрочен!",
                passport.getSeries(), passport.getNumber());
    }
}
