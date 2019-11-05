package ru.otus.task04.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    private final String language;
    private final String country;
    private final String filepath;

    public AppProperties(@Value("${locale.language}") String language,
                         @Value("${locale.country}")String country,
                         @Value("${file.path}") String filepath) {
        this.language = language;
        this.country = country;
        this.filepath = filepath;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getFilepath() {
        return filepath;
    }
}
