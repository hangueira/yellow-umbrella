package com.hks.yellowumbrella.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Lob
    private String contentLob;

    private String author;

    @Builder
    public Hello(String title, String content, String contentLob, String author) {
        this.title = title;
        this.content = content;
        this.contentLob = contentLob;
        this.author = author;
    }
}
