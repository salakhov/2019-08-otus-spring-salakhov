package ru.otus.library.task06.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import ru.otus.library.task06.domain.Author;
import ru.otus.library.task06.domain.Book;
import ru.otus.library.task06.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String title = resultSet.getString("title");
        long author_id = resultSet.getLong("author_id");
        long genre_id = resultSet.getLong("genre_id");
//        Author author = authorDao.getAuthorById(author_id);
//        Genre genre = genreDao.getGenreById(genre_id);
//        return new Book(id, title, author, genre);
        return null;
    }

}
