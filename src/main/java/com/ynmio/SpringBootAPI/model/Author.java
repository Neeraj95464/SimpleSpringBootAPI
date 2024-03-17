package com.ynmio.SpringBootAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    private String name;
    private String language;
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
