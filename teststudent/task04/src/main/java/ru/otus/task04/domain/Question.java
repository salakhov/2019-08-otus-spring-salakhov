package ru.otus.task04.domain;

/**
 * Класс вопрос. служит для хранения вопросов теста
 */

public class Question {
    private String question;

    public Question(String question) {
        this.question = question;
    }

    public String getText() {
        return question;
    }
}
