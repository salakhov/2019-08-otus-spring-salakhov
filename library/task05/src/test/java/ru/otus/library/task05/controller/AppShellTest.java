package ru.otus.library.task05.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.library.task05.dao.AuthorDao;
import ru.otus.library.task05.dao.AuthorDaoImpl;
import ru.otus.library.task05.dao.BookDao;
import ru.otus.library.task05.dao.BookDaoImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест shell")
@SpringBootTest

//@Import(AuthorDaoImpl.class)
//@Import(BookDaoImpl.class)
class AppShellTest {
    @Autowired
    private Shell shell;

    private static final String GREETING_PATTERN="Welcome: %s";
    private static final String DEFAILT_LOGIN = "user";
    private static final String CUSTOM_LOGIN = "alex";
    private static final String COMMAND_LOGIN = "l";


    @DisplayName("Должен возвращать приветствие для всех форм логина")
    @Test
    void shourdReturnExpectedGreetimgAfterLogin() {
        String res = (String) shell.evaluate(()->COMMAND_LOGIN);
        assertThat(res).isEqualTo(GREETING_PATTERN,DEFAILT_LOGIN);
    }

    @Test
    void getAuthor() {
    }

    @Test
    void getAllAuthor() {
    }

    @Test
    void getAllAuthorByLastname() {
    }

    @Test
    void getAllBooks() {
    }

    @Test
    void getAllGenres() {
    }

    @Test
    void searchAllAuthorsOfBook() {
    }
}