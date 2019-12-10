//package ru.otus.library.task05.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ResultSetExtractor;
//import ru.otus.library.task05.domain.Author;
//import ru.otus.library.task05.domain.Book;
//import ru.otus.library.task05.domain.Genre;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedList;
//import java.util.List;
//
//public class BookResultSetExtractor implements ResultSetExtractor {
//
//    @Override
//    public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//
//        List<Book> bookList = new LinkedList<>();
//
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
//    }
//}