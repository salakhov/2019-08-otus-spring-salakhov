package ru.otus.library.task05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BookResultSetExtractor implements ResultSetExtractor {
    @Autowired
    AuthorDao authorDao;

    @Override
    public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Author author;
        Genre genre;
        List<Book> bookList = new LinkedList<>();

        while (resultSet.next()){
            long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            long author_id = resultSet.getLong("author_id");
            long genre_id = resultSet.getLong("genre_id");
            author = authorDao.getAuthorById(author_id);
        }
        return bookList;
    }
}
