package ru.otus.task03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import ru.otus.task03.config.AppProperties;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {
    private Locale locale;
    private String language;
    private String country;

    @Autowired
    MessageSource messageSource;

    public LocaleServiceImpl(AppProperties appProperties) {
        this.language = appProperties.getLanguage();
        this.country = appProperties.getCountry();
        this.locale = new Locale(language,country);
    }

    @Override
    public String getMessage(String messageSource){
        return this.messageSource.getMessage(messageSource,new String[] {},locale);
    }
}
