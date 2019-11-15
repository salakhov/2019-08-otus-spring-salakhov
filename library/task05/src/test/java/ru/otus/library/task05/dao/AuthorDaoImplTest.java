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
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DAO для работы c авторами возвращает:")
@ExtendWith(SpringExtension.class)
@JdbcTest
@Import(AuthorDaoImpl.class)

class AuthorDaoImplTest {
    private static final long DEFAULT_AUTHOR_ID = 1;
    private static final long DEFAULT_AUTHOR_COUNT=4;
    @Autowired
    private AuthorDaoImpl authorDao;

    @DisplayName("по ID")
    @Test
    void getAuthorById() {
        assertThat(authorDao.getAuthorById(DEFAULT_AUTHOR_ID)).hasFieldOrPropertyWithValue("lastname","Пушкин");
    }
    @DisplayName("количество")
    @Test
    void getAuthorCount(){
        assertThat(authorDao.getAuthorCount()).isEqualTo(DEFAULT_AUTHOR_COUNT);
    }

    @DisplayName("по фамилии")
    @Test
    void getAuthorByLastName() {
        assertThat(authorDao.getAuthorByLastName("Пушкин")).hasFieldOrPropertyWithValue("firstname","Александр");
    }

    @DisplayName("всех авторов")
    @Test
    void getAllAuthors() {
        assertThat(authorDao.getAllAuthors()).doesNotContainNull();
    }
}