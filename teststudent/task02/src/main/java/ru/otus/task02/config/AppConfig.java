package ru.otus.task02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;
import ru.otus.task02.dao.TestDao;
import ru.otus.task02.dao.TestDaoImpl;
import ru.otus.task02.service.*;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan
public class AppConfig {

    @Autowired
    @Bean
    public UserService userService(ConsoleService consoleService){
        return new UserServiceImpl(consoleService);

    }
    @Autowired
    @Bean
    public TestService testService(TestDao dao,UserService userService){
        return new TestServiceImpl(dao,userService);
    }
    @Bean
    public TestDao testDao(@Value("${file.path}") String resource,@Value("${locale.language}") String locale){
        return new TestDaoImpl(resource,locale);
    }

    @Autowired
    @Bean
    public ConsoleService consoleService(LocaleService locale){
        return new ConsoleServiceImpl(locale);
    }

    @Bean
    public LocaleService LocaleService(@Value("${locale.language}") String language,
            @Value("${locale.country}") String country){
        return new LocaleServiceImpl(language,country);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}