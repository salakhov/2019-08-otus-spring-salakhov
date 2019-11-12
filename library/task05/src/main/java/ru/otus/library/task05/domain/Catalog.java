package ru.otus.library.task05.domain;

public class Catalog {
    private long id;
    private long libraryId;
    private long authorId;
    private long genreId;
    private long bookId;

    public long getId() {
        return id;
    }

    public long getLibraryId() {
        return libraryId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public long getGenreId() {
        return genreId;
    }

    public long getBookId() {
        return bookId;
    }
}
