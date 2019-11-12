package ru.otus.library.task05.service;

import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;

import java.util.List;

public interface CatalogService {
    List<Author> searchAllAuthorsOfBook(Book book);
    List<Book> searchAllBooksOfAuthor(Author book);
}
