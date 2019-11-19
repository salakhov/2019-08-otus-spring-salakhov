package ru.otus.library.task05.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.jdbc=namedParameterJdbcOperations.getJdbcOperations();
    }

    @Override
    public Author getAuthorById(long id){
        Map<String, Object> params = Collections.singletonMap("id", id);
        Author author =namedParameterJdbcOperations.queryForObject(
                "select id,first_name,last_name,second_name from authors where id = :id",params, new AuthorMapper());
        return author;
    }

    @Override
    public Author getAuthorByLastName(String lastname){
        Map<String, Object> params = Collections.singletonMap("last_name", lastname);
        Author author =namedParameterJdbcOperations.queryForObject(
                "select id,first_name,last_name,second_name from authors where last_name = :last_name",params, new AuthorMapper());
        return author;
    }

    @Override
    public List<Author> getAllAuthors(){
        return jdbc.query("select * from authors",new AuthorMapper());
    }

    @Override
    public long getAuthorCount() {
        return jdbc.queryForObject("select count(*) from authors",Integer.class);
    }

    @Override
    public void insertAuthor(Author author) {
        jdbc.update("insert into authors (id,first_name,last_name,second_name)" +
                "values (?,?,?,?)", author.getFirstName(),author.getLastName(),author.getSecondName());
    }
    @Override
    public List<Author> searchAllAuthorsOfBook(Book book) {
        Map<String, Object> params = Collections.singletonMap("book_title", book.getTitle());
        String str = "select a.id,a.first_name,a.second_name,a.last_name from AUTHORS a " +
                "where a.id in (select c.author_id from catalog c " +
                "where c.book_id=(select id from books where title=:book_title))";
        return namedParameterJdbcOperations.query(str, params, new AuthorMapper());
    }
}
