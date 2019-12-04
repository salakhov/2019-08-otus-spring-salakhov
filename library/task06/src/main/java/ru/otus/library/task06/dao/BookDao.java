package ru.otus.library.task06.dao;

import ru.otus.library.task06.domain.Author;
import ru.otus.library.task06.domain.Book;
import ru.otus.library.task06.domain.Genre;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    List<Book> getBooksByTitle(String title);
    List<Book> searchAllBooksOfAuthor(Author book);
    List<Book> searchAllBooksOfGenre(Genre book);
}
