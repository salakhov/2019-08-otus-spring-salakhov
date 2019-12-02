package ru.otus.library.task05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ДАО book должен возвращать:")
@ExtendWith(SpringExtension.class)
@JdbcTest
@Import(BookDaoImpl.class)
class BookDaoImplTest {

    @Autowired
    BookDaoImpl bookDao;

    @DisplayName("Все книги")
    @Test
    void shouldReturnAllBooks() {
        assertThat(bookDao.getAllBooks()).doesNotContainNull();
    }

    @DisplayName("книгу по названию")
    @Test
    void getBookByTitle() {
        assertThat(bookDao.getBooksByTitle("Евгений Онегин")).hasAtLeastOneElementOfType(Book.class);
    }

    @DisplayName("Все книги автора")
    @Test
    void searchAllBooksOfAuthor() {
        Author author = new Author(1,"Александр","Пушкин","Сергеевич");
        assertThat(bookDao.searchAllBooksOfAuthor(author)).hasAtLeastOneElementOfType(Book.class);
    }

}