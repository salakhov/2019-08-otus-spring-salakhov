package ru.otus.library.task05.dao;

import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.domain.Genre;

import java.util.List;

public interface CatalogDao {
    List<Author> searchAllAuthorsOfBook(Book book);
    List<Book> searchAllBooksOfAuthor(Author book);
    List<Book> searchAllBooksOfGenre(Genre book);
}
