package ru.otus.library.task05.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.domain.Genre;

import java.util.List;

@Repository
public class CatalogDaoImpl implements CatalogDao {
    JdbcOperations jdbc;
    NamedParameterJdbcOperations namedParameterJdbcOperations;

    public CatalogDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public List<Author> searchAllAuthorsOfBook(Book book) {


        return namedParameterJdbcOperations.query(
                "select id,first_name,second_name,last_name from AUTHORS ",
                new AuthorMapper());
    }

    @Override
    public List<Book> searchAllBooksOfAuthor(Author book) {
        return null;
    }

    @Override
    public List<Book> searchAllBooksOfGenre(Genre book) {
        return null;
    }
}
