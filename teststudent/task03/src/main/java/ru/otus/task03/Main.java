package ru.otus.task03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.otus.task03.service.TestService;

import java.util.Arrays;

@SpringBootApplication
public class Main{

    public static void main(String[] args) {
	    ApplicationContext appContext = SpringApplication.run(Main.class, args);
        TestService testService = appContext.getBean(TestService.class);
        testService.startTest();

	}
}