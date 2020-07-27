package com.infinty.wordsclients.rest;

import com.infinty.wordsclients.models.Sentence;
import com.infinty.wordsclients.services.WordsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController public class WordsController {

    private final WordsService wordsService;

    public WordsController(WordsService wordsService) {
        this.wordsService = wordsService;
    }

    @GetMapping("/api/getSentence") public ResponseEntity<Sentence> getSentence() {
        return ResponseEntity.ok(this.wordsService.getSentence());
    }

    @PutMapping("/api/addWord/{word}") public String addWords(@PathVariable String word) {

        this.wordsService.sendToBroker(word);
        return "ok";

    }

}
