package com.hks.yellowumbrella.repository;

import com.hks.yellowumbrella.domain.Hello;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloRepositoryTest {

    @Autowired
    HelloRepository helloRepository;

    @BeforeEach
    void cleanup() {
        helloRepository.deleteAll();
    }

    @Test
    void hello_entity_save() {
        Hello saveHello = helloRepository.save(
                Hello.builder()
                        .title("Test Title")
                        .content("Test Content")
                        .contentLob("Test Content Lob")
                        .author("Test Author")
                        .build());
        List<Hello> hellos = helloRepository.findAll();

        assertThat(hellos.get(0).getId()).isEqualTo(1L);
        assertThat(hellos.get(0).getAuthor()).isEqualTo("Test Author");


    }


}