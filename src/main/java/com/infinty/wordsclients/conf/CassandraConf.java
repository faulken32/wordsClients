package com.infinty.wordsclients.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories
@Configuration public class CassandraConf {

   @Bean
    public CqlSessionFactoryBean session() {



        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setLocalDatacenter("datacenter1");
        session.setKeyspaceName("words");

        return session;
    }
}
