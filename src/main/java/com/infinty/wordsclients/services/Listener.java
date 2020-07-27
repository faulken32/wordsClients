package com.infinty.wordsclients.services;

import com.infinty.wordsclients.models.Sentence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j @Component public class Listener {

    private final WordsService wordsService;

    public Listener(WordsService wordsService) {
        this.wordsService = wordsService;
    }

    @KafkaListener(topics = "sentence") public void listen(String message) {

        log.info("Received Messasge: {}", message);

        final Sentence sentence = wordsService.saveToDb(message);

        log.info("i have save {}" , sentence.toString());

    }
}
