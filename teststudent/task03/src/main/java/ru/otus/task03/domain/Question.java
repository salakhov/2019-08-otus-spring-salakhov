package ru.otus.task03.domain;

/**
 * Класс вопрос. служит для хранения вопросов теста
 */

public class Question {
    private final String question;

    public Question(String question) {
        this.question = question;
    }

    public String getText() {
        return question;
    }
}
