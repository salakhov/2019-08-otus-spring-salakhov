package ru.otus.library.task05.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.library.task05.domain.Author;

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
}
