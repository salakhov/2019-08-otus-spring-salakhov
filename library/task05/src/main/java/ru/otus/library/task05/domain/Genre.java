package ru.otus.library.task05.domain;

public class Genre {
    private final String name;
    private final long id;

    public Genre(long id, String name) {
        this.id =id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
