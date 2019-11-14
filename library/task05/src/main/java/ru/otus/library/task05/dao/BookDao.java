package ru.otus.library.task05.dao;

import ru.otus.library.task05.domain.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    List<Book> getBookByTitle(String title);
}
