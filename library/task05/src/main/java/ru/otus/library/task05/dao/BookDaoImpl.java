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
public class BookDaoImpl implements BookDao {
    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) jdbc.query("select b.id, b.title,b.author_id, b.genre_id,a.first_name,a.second_name,a.last_name,g.id,g.name\n" +
                "from books b, authors a,genres g where b.genre_id=g.id and a.id = b.author_id",new BookResultSetExtractor());
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        Map<String, Object> params = Collections.singletonMap("title", title);
        return namedParameterJdbcOperations.query("select id, title,author_id,genre_id from books where title = :title",params,new BookMapper());
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
