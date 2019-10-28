package ru.otus.task02.service;

import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import ru.otus.task02.config.AppProperties;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {
    final private Locale locale;
    final private String language;
    final private String country;

    private MessageSource messageSource;

    public LocaleServiceImpl(AppProperties appProperties,MessageSource messageSource) {
        this.language = appProperties.getLanguage();
        this.country = appProperties.getCountry();
        this.locale = new Locale(language,country);
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String messageSource){
        return this.messageSource.getMessage(messageSource,new String[] {},locale);
    }
}
