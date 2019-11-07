package ru.otus.library.task05.domain;

public class Author {
    private final String firstname;
    private final String lastname;

    public Author(long id, String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
