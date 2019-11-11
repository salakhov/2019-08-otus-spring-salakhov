package ru.otus.library.task05.domain;

public class Author {
    private final String firstname;
    private final String lastname;
    private final String secondname;

    public Author(long id, String firstname, String lastname,String secondname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.secondname = secondname;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }
    public String getSecondName() {
        return secondname;
    }
}
