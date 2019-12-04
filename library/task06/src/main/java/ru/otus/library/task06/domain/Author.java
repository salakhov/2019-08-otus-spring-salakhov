package ru.otus.library.task06.domain;

public class Author {
    private final long id;
    private final String firstname;
    private final String lastname;
    private final String secondname;

    public Author(long id, String firstname, String lastname,String secondname) {
        this.id = id;
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

    public long getId() {
        return id;
    }
}
