package ru.otus.library.task05.dao;

import ru.otus.library.task05.domain.Author;

import java.util.List;

public interface AuthorDao {
    Author getAuthorById(long id);
    List<Author> getAllAuthors();
    Author getAuthorByLastName(String lastname);
    long getAuthorCount();
    void insertAuthor(Author author);
}
