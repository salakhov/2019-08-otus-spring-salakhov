package ru.otus.task01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.task01.domain.Test;
import ru.otus.task01.service.TestService;
import ru.otus.task01.service.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-context.xml");

        //TestService testService = ctx.getBean(TestService.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.runTest();
    }
}
