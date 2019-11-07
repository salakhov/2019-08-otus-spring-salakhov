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
    public Author getById(long id){
        Map<String, Object> params = Collections.singletonMap("id", id);
        Author author =namedParameterJdbcOperations.queryForObject(
                "select id,first_name,last_name from authors where id = :id",params, new AuthorMapper());
        return author;
    }
}
