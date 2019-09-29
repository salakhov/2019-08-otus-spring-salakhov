package ru.otus.task01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.task01.service.QuestionService;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService question = ctx.getBean(QuestionService.class);
        question.getQuestion();

        //InputStream is = getClass().getResourceAsStream("questions.csv");

    }
}
