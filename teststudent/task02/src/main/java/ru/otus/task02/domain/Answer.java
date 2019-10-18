package ru.otus.task02.domain;

/**
 * класс ответ. Служит для хранения ответов на вопросы
 */

public class Answer {
    String answer;

    public String getText() {
        return answer;
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object obj) {
        return answer.equalsIgnoreCase(obj.toString());
    }
}
