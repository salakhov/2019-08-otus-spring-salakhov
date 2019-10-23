package ru.otus.task03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.task03.service.TestService;

@SpringBootApplication
@EnableConfigurationProperties
public class Main implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.run();

//	    SpringApplication.run(Main.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        TestService testService = ctx.getBean(TestService.class);
        testService.startTest();
    }
}