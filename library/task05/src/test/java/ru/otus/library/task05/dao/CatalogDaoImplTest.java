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

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест CatalogDao возвращает:")
@ExtendWith(SpringExtension.class)
@JdbcTest
@Import(CatalogDaoImpl.class)
class CatalogDaoImplTest {
    @Autowired
    CatalogDaoImpl catalogDao;

    @DisplayName("Всех авторов книги")
    @Test
    void searchAllAuthorsOfBook() {
        Book book = new Book(3, "Постигая Agile");
        assertThat(catalogDao.searchAllAuthorsOfBook(book)).hasAtLeastOneElementOfType(Author.class);
    }

    @DisplayName("Все книги автора")
    @Test
    void searchAllBooksOfAuthor() {
        Author author = new Author(1,"Александр","Пушкин","Сергеевич");
        assertThat(catalogDao.searchAllBooksOfAuthor(author)).hasAtLeastOneElementOfType(Book.class);
    }

}