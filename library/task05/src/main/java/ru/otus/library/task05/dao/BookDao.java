package ru.otus.library.task05.dao;

import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.domain.Genre;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    List<Book> getBooksByTitle(String title);
    List<Book> searchAllBooksOfAuthor(Author book);
}
