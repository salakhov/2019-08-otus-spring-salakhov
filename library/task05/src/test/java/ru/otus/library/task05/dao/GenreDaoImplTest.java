package ru.otus.library.task05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ДАО genre должен возвращать:")
@ExtendWith(SpringExtension.class)
@JdbcTest
@Import(GenreDaoImpl.class)
class GenreDaoImplTest {
    @Autowired
    GenreDaoImpl genreDao;

    @DisplayName("Все жанры")
    @Test
    void shouldReturnAllGenres() {
        assertThat(genreDao.getAllGenres()).isNotEmpty();
    }
}