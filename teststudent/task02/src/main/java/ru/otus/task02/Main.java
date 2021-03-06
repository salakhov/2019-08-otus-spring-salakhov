package ru.otus.task02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.task02.service.TestService;
import ru.otus.task02.service.UserService;
@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        TestService testService = ctx.getBean(TestService.class);
        testService.startTest();
    }
}
