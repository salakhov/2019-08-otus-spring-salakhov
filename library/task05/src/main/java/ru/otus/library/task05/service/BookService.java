package ru.otus.library.task05.service;

import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getBooksByTitle(String title);
    List<Book> searchAllBooksOfAuthor(Author book);
}
