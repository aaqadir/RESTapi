package com.restapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    private int id;
    @Column(name = "book_title")
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
