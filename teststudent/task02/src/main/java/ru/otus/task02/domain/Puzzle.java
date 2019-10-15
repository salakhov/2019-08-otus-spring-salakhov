package ru.otus.task02.domain;
import java.util.List;

/**
 * Класс Пазл. Объект для хрененния вопроса, правильного ответа, ответа пользователя и списка вариантов ответа
 * что соответствует строчке в фале ресурса
 */

public class Puzzle {
    private Question question;
    private Answer rightAnswer;
    private Answer userAnswer;
    private List<Answer> answerList;


    public Puzzle(Question question, Answer rightAnswer, List<Answer> answerList) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answerList = answerList;
    }

    public Question getQuestion() {
        return question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
    public void setUserAnswer(Answer userAnswer){
        this.userAnswer = userAnswer;
    }
    public boolean checkAnswer(){
        return userAnswer.equals(rightAnswer);
    }
}
