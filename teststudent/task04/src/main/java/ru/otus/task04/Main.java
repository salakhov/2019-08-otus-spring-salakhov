package ru.otus.task04;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.task04.service.TestService;


@SpringBootApplication
public class Main{

    public static void main(String[] args) {
	    ApplicationContext appContext = SpringApplication.run(Main.class, args);
        TestService testService = appContext.getBean(TestService.class);
        testService.startTest();
	}
}