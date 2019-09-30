package ru.otus.task01.domain;

public class Question {
    private String text;

    public String getText() {
        return text;
    }

    public Question(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
