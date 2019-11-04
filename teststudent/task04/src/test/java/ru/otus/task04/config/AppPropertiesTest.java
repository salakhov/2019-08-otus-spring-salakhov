package ru.otus.task04.config;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.task04.service.LocaleService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Клнфигурация должна содержать")
@SpringBootTest
class AppPropertiesTest {

    @MockBean
    AppProperties appProperties;

    @MockBean
    LocaleService localeService;

    @Test
    void getLanguage() {
        assertThat(appProperties).isNotNull();
        assertThat(appProperties.getLanguage()).isNotNull();
    }

    @Test
    void getCountry() {
    }

    @Test
    void getFilepath() {
    }
}