package ru.otus.task02;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.task02.domain.Test;
import ru.otus.task02.domain.User;
import ru.otus.task02.service.TestService;
import ru.otus.task02.service.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-context.xml");

        //TestService testService = ctx.getBean(TestService.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.TestUser();
    }
}
