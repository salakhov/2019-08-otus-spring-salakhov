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
                "from books b, authors a,genres g where b.genre_id=g.id and b.author_id = a.id",new BookResultSetExtractor());
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        Map<String, Object> params = Collections.singletonMap("book_title", title);
        String str = "select b.id, b.title,b.author_id, b.genre_id,a.first_name,a.second_name,a.last_name,g.id,g.name\n" +
                "from books b, genres g, authors a where b.genre_id=g.id and b.author_id=a.id and b.title=:book_title";
        return (List<Book>) namedParameterJdbcOperations.query(str,params,new BookResultSetExtractor());

    }
    @Override
    public List<Book> searchAllBooksOfAuthor(Author author) {
        Map<String,Object> params = Collections.singletonMap("author_id",author.getId());
        String query = "select b.id, b.title,b.author_id, b.genre_id,a.first_name,a.second_name,a.last_name,g.id,g.name\n" +
                "from books b, authors a,genres g where b.genre_id=g.id and b.author_id = :author_id";
        return (List<Book>) namedParameterJdbcOperations.query(query,params,new BookResultSetExtractor());

    }
    @Override
    public List<Book> searchAllBooksOfGenre(Genre book) {
        return null;
    }
}
