package ru.otus.task04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import ru.otus.task04.config.AppProperties;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {
    private final Locale locale;
    private final String language;
    private final String country;

    private final MessageSource messageSource;

    public LocaleServiceImpl(AppProperties appProperties,MessageSource messageSource) {
        this.language = appProperties.getLanguage();
        this.country = appProperties.getCountry();
        this.locale = new Locale(language,country);
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String messageKey){
        return this.messageSource.getMessage(messageKey,new String[] {},locale);
    }
}
