package ru.otus.library.task05.domain;

public class Book {
    private final String title;
    private final long id;
    private final Author author;
    private final Genre genre;

    public Book(long id,String title,Author author,Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }
}
