package ru.otus.library.task05.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.domain.Genre;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> params = Collections.singletonMap("book_title", book.getTitle());
        String str ="select a.id,a.first_name,a.second_name,a.last_name from AUTHORS a " +
                "where a.id in (select c.author_id from catalog c " +
                "where c.book_id=(select id from books where title=:book_title))";
        return namedParameterJdbcOperations.query(str,params,new AuthorMapper());
    }

    @Override
    public List<Book> searchAllBooksOfAuthor(Author author) {
        Map<String,Object> params = Collections.singletonMap("lastname",author.getLastName());
        String query = "select b.id, b.title from books b where b.id in (select c.book_id from catalog c" +
                " where c.author_id=(select id from authors where last_name=:lastname))";
        return namedParameterJdbcOperations.query(query,params,new BookMapper());
    }

    @Override
    public List<Book> searchAllBooksOfGenre(Genre book) {
        return null;
    }
}
