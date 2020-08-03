package com.infinty.wordsclients.services;

import com.infinty.wordsclients.models.Sentence;
import com.infinty.wordsclients.repository.WordsRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @Slf4j public class WordsService {

    private final WordsRepo                     wordsRepo;
    private final KafkaTemplate<String, String> template;
    private static final String                        TOPIC = "words";

    public WordsService(WordsRepo wordsRepo, KafkaTemplate<String, String> template) {
        this.wordsRepo = wordsRepo;
        this.template = template;
    }

    /**
     * save or add word  to sentence
     *
     * @param word
     * @return
     */
    public Sentence saveToDb(String word) {

        log.info("i save to db {}" ,word );

        if (StringUtils.isNotEmpty(word)) {
            word = word.trim();
            final long count = this.wordsRepo.count();
            if (count == 0) {
                final Sentence sentence = new Sentence();
                sentence.setId(UUID.randomUUID());
                sentence.setWords(word);
                return this.wordsRepo.save(sentence);
            } else {

                final Iterable<Sentence> all = this.wordsRepo.findAll();
                final Sentence next = all.iterator().next();
                next.setWords(word);

                return this.wordsRepo.save(next);
            }
        }
        return null;
    }

    public void sendToBroker(String word) {
        this.template.send(TOPIC , word);
    }

    public Sentence getSentence() {

        if (this.wordsRepo.findAll().iterator().hasNext()){

            return this.wordsRepo.findAll().iterator().next();
        } else {
            return new Sentence();
        }

    }
}
