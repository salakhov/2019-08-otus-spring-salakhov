package ru.otus.task02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.task02.dao.TestDao;
import ru.otus.task02.dao.TestDaoImpl;
import ru.otus.task02.service.*;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan

public class AppConfig {

    public UserService userService(ConsoleService consoleService){
        return new UserServiceImpl(consoleService);

    }
    public TestService testService(TestDao dao,UserService userService){
        return new TestServiceImpl(dao,userService);
    }
    public TestDao testDao(@Value("${file.path}") String resource,@Value("${locale.language}") String locale){
        return new TestDaoImpl(resource,locale);
    }

    //@Autowired
    public ConsoleService consoleService(LocaleService locale){
        return new ConsoleServiceImpl(locale);
    }

    public LocaleService LocaleService(@Value("${locale.language}") String language,
            @Value("${locale.country}") String country){
        return new LocaleServiceImpl(language,country);
    }

    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}