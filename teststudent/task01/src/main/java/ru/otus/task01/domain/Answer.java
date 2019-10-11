package ru.otus.task01.domain;

/**
 * класс ответ. Служит для хранения ответов на вопросы
 */

public class Answer {
    String answer;

    public String getAnswer() {
        return answer;
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public void print(){
        System.out.println("answer: "+answer.toString());
    }

    @Override
    public boolean equals(Object obj) {
        return answer.equalsIgnoreCase(obj.toString());
    }

    @Override
    public String toString() {
        return answer;
    }
}
