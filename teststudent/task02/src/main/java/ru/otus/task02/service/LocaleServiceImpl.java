package ru.otus.task02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import ru.otus.task02.config.AppProperties;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {
    final private Locale locale;
    final private String language;
    final private String country;

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
