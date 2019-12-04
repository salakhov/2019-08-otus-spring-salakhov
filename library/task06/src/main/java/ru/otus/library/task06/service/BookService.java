package ru.otus.library.task06.service;

import ru.otus.library.task06.domain.Author;
import ru.otus.library.task06.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getBooksByTitle(String title);
    List<Book> searchAllBooksOfAuthor(Author book);
}
