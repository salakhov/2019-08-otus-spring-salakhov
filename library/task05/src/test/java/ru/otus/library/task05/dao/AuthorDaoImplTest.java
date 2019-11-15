package ru.otus.library.task05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("DAO для работы c авторами. Авторов получаем")
@ExtendWith(SpringExtension.class)
@JdbcTest
@Import(AuthorDaoImpl.class)

class AuthorDaoImplTest {
    @Autowired
    private AuthorDaoImpl authorDao;

    @DisplayName("по ID")
    @Test
    void getAuthorById() {

    }

    @DisplayName("по фамилии")
    @Test
    void getAuthorByLastName() {
    }

    @Test
    void getAllAuthors() {
    }
}