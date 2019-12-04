package ru.otus.library.task05.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.shell.CommandNotCurrentlyAvailable;
import org.springframework.shell.Shell;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.library.task05.dao.AuthorDao;
import ru.otus.library.task05.dao.AuthorDaoImpl;
import ru.otus.library.task05.dao.BookDao;
import ru.otus.library.task05.dao.BookDaoImpl;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест shell")
@SpringBootTest

class AppShellTest {

    @Autowired
    private Shell shell;

    private static final String GREETING_PATTERN="Welcome: %s";
    private static final String DEFAILT_LOGIN = "user";
    private static final String CUSTOM_LOGIN = "alex";
    private static final String COMMAND_LOGIN = "l";
    private static final String COMMAND_LOGIN_USER_PATTERN = "l alex";
    private static final String COMMAND_GET_ALL_AUTHORS = "gaa";
    private static final String COMMAND_GET_AUTHOR_BY_LASTNAME_TEMPLATE ="gabl Пушкин";
    private static final String COMMAND_GET_AUTHOR_BY_ID ="gabi 1" ;
    private static final String COMMAND_GET_ALL_BOOK = "gab";
    private static final String COMMAND_GET_ALL_GENRES ="gag";
    private static final String COMMAND_SEARCH_AUTHORS_OF_BOOK_TEMPL ="sab %s";

    @DisplayName("Должен возвращать приветствие для всех форм логина")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void shouldReturnExpectedGreetimgAfterLogin() {
        String res = (String) shell.evaluate(()->COMMAND_LOGIN);
        assertThat(res).isEqualTo(GREETING_PATTERN,DEFAILT_LOGIN);
        res = (String) shell.evaluate(()->String.format(COMMAND_LOGIN_USER_PATTERN,CUSTOM_LOGIN));
        assertThat(res).isEqualTo(String.format(GREETING_PATTERN,CUSTOM_LOGIN));
    }

    @DisplayName("Должен требовать login перед операцией получения автора")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void getAuthor() {
        Object res = shell.evaluate(()->COMMAND_GET_ALL_AUTHORS);
        assertThat(res).isInstanceOf(CommandNotCurrentlyAvailable.class);
    }

    @DisplayName("Должен возвращать список всех авторов")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void getAllAuthors() {
        shell.evaluate(()->COMMAND_LOGIN);
        Object res = shell.evaluate(()->COMMAND_GET_ALL_AUTHORS);
        assertThat(res).asList();
    }

    @DisplayName("Должен найти автора по фамилии")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void getAuthorByLastName() {
        shell.evaluate(()->COMMAND_LOGIN);
        Object res = shell.evaluate(()->COMMAND_GET_AUTHOR_BY_LASTNAME_TEMPLATE);
        assertThat(res).isInstanceOf(Author.class);
    }

    @DisplayName("Дoлжен найти фамилию автора по ID")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void getAuthorLastNameById(){
        shell.evaluate(()->COMMAND_LOGIN);
        Object res = shell.evaluate(()->COMMAND_GET_AUTHOR_BY_ID);
        assertThat(res).isEqualTo("Пушкин");
    }

    @DisplayName("Получить все книги")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void getAllBooks() {
        shell.evaluate(()->COMMAND_LOGIN);
        Object res = shell.evaluate(()->COMMAND_GET_ALL_BOOK);
        assertThat(res).asList();
    }

    @DisplayName("Получить все жанры")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void getAllGenres() {
        shell.evaluate(()->COMMAND_LOGIN);
        Object res = shell.evaluate(()->COMMAND_GET_ALL_GENRES);
        assertThat(res).asList();
    }
}