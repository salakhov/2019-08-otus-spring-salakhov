package ru.otus.task04.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.CommandNotCurrentlyAvailable;
import org.springframework.shell.Shell;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("Тест команд Shell")
@SpringBootTest
class AppShellServiceImplTest {

    @Autowired
    private Shell shell;

    private static final String GREETING_PATTERN = "Welcome: %s %s";
    private static final String DEFAULT_NAME = "mikhail";
    private static final String DEFAULT_LASTNAME = "salakhov";
    private static final String CUSTOM_NAME = "victor";
    private static final String CUSTOM_LASTNAME = "sukhorukov";

    private static final String COMMAND_LOGIN = "login";
    private static final String COMMAND_LOGIN_SHORT = "l";
    private static final String COMMAND_LOGIN_PATTERN = "%s %s %s";

    private static final String COMMAND_RUNTEST = "r";
    @DisplayName(" должен возвращать приветствие для всех форм команды логина")
    @Test
    void shouldReturnExpectedGreetingAfterLoginCommandEvaluated() {
        String res = (String) shell.evaluate(() -> COMMAND_LOGIN);
        assertThat(res).isEqualTo(String.format(GREETING_PATTERN, DEFAULT_NAME,DEFAULT_LASTNAME));

        res = (String) shell.evaluate(() -> COMMAND_LOGIN_SHORT);
        assertThat(res).isEqualTo(String.format(GREETING_PATTERN, DEFAULT_NAME,DEFAULT_LASTNAME));

        res = (String) shell.evaluate(() -> String.format(COMMAND_LOGIN_PATTERN, COMMAND_LOGIN_SHORT, CUSTOM_NAME,CUSTOM_LASTNAME));
        assertThat(res).isEqualTo(String.format(GREETING_PATTERN, CUSTOM_NAME,CUSTOM_LASTNAME));
    }

    @DisplayName(" должен возвращать CommandNotCurrentlyAvailable если при попытке выполнения команды run пользователь выполнил вход")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void shouldReturnCommandNotCurrentlyAvailableObjectWhenUserDoesNotLoginAfterPublishCommandEvaluated() {
        Object res =  shell.evaluate(() -> COMMAND_RUNTEST);
        assertThat(res).isInstanceOf(CommandNotCurrentlyAvailable.class);
    }
}