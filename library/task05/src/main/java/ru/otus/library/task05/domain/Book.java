package ru.otus.library.task05.domain;

public class Book {
    private final String title;
    private final long id;

    public Book(long id,String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }
}
