package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    //todo BookId id;
    @EmbeddedId
    private BookId id;
    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(){

    }

    public Book(BookId id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookId getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
