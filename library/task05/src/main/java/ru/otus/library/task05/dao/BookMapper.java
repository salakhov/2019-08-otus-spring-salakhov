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

//        while (resultSet.next()){
//            long id = resultSet.getLong("id");
//            String title = resultSet.getString("title");
//            long author_id = resultSet.getLong("author_id");
//            long genre_id = resultSet.getLong("genre_id");
//            String genre_name = resultSet.getString("name");
//            String author_fist_name = resultSet.getString("first_name");
//            String author_second_name = resultSet.getString("second_name");
//            String author_last_name = resultSet.getString("last_name");
//            Genre genre = new Genre(genre_id,genre_name);
//            Author author = new Author(author_id,author_fist_name,author_last_name,author_second_name);
//            Book book = new Book(id,title,author,genre);
//            bookList.add(book);
//        }
//        return bookList;

        long id = resultSet.getLong("id");
        String title = resultSet.getString("title");
        long author_id = resultSet.getLong("author_id");
        long genre_id = resultSet.getLong("genre_id");
        Author author = authorDao.getAuthorById(author_id);
        Genre genre = genreDao.getGenreById(genre_id);
        return new Book(id, title, author, genre);
//        return null;
    }

}
