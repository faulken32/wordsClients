package com.infinty.wordsclients.models;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import java.util.UUID;

@Table @Data public class Sentence {

    @PrimaryKey private UUID id;

    @Indexed private String words;

    @Override public String toString() {
        return new ToStringBuilder(this).append("id", id).append("words", words).toString();
    }
}
