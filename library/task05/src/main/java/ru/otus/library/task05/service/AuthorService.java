package ru.otus.library.task05.service;

import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;

import java.util.List;

public interface AuthorService {
    Author getAuthor(long id);
    List<Author> getAllAuthors();
    Author getAuthorByLastName(String lastname);
    List<Author> searchAllAuthorsOfBook(Book book);
}
