package com.infinty.wordsclients.repository;

import com.infinty.wordsclients.models.Sentence;
import org.springframework.data.repository.CrudRepository;

public interface WordsRepo extends CrudRepository<Sentence, String> {
}
