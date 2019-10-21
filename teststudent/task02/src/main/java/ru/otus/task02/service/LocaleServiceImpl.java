package ru.otus.task02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {
    private Locale locale;
    private String language;
    private String country;

    @Autowired
    MessageSource messageSource;

    public LocaleServiceImpl(@Value("${locale.language}") String language, @Value("${locale.country}") String country) {
        this.language = language;
        this.country = country;
        locale = new Locale(language,country);
    }

    @Override
    public String getMessage(String messageSource){
        return this.messageSource.getMessage("user.name",new String[] {},locale);
    }
}
