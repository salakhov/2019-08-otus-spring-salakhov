package ru.otus.library.task05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DAO для работы c авторами возвращает:")
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


    @DisplayName("Всех авторов книги")
    @Test
    void searchAllAuthorsOfBook() {
        Author author = new Author(3,"Джениффер","","Грин");
        Genre genre = new Genre(3,"программирование");
        Book book = new Book(3, "Постигая Agile",author,genre);
        assertThat(authorDao.searchAllAuthorsOfBook(book)).hasAtLeastOneElementOfType(Author.class);
    }

}