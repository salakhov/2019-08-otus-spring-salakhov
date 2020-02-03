package ru.otus.library.task05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BookMapper implements RowMapper<Book> {
    @Autowired
    AuthorDao authorDao;

    @Autowired
    GenreDao genreDao;

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String title = resultSet.getString("title");
        long author_id = resultSet.getLong("author_id");
        long genre_id = resultSet.getLong("genre_id");
        Author author = authorDao.getAuthorById(author_id);
        Genre genre = genreDao.getGenreById(genre_id);
        return new Book(id, title, author, genre);
    }

}
