package ru.otus.library.task05.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.library.task05.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String first_name = resultSet.getString("first_name");
        String last_name = resultSet.getString("last_name");
        String second_name = resultSet.getString("second_name");
        return new Author(id, first_name, last_name,second_name);
    }
}
