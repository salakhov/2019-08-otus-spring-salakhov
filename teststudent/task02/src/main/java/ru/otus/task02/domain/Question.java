package ru.otus.task02.domain;

/**
 * Класс вопрос. служит для хранения вопросов теста
 */

public class Question {
    private String text;

    public Question(String text) {
        this.text = text;
    }

    public void print(){
        System.out.println(text);
    }

    @Override
    public String toString() {
        return text;
    }
}
