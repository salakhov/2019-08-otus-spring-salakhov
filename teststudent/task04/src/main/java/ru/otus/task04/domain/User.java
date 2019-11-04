package ru.otus.task04.domain;

import org.springframework.stereotype.Component;

//@Component
public class User {
    private String firstName;
    private String secondName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
