package ru.otus.task01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.task01.domain.Question;
import ru.otus.task01.service.QuestionService;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-context.xml");
        QuestionService questionService = ctx.getBean(QuestionService.class);
        Question question = questionService.getQuestion();
        System.out.println(question.getText());



    }
}
