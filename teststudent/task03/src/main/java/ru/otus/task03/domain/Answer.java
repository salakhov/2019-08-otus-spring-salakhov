package ru.otus.task03.domain;

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
        Answer ans1 = (Answer)obj;
        return this.getText().equalsIgnoreCase(ans1.getText());
    }
}
