package ru.otus.library.task05.service;

import org.springframework.stereotype.Service;
import ru.otus.library.task05.dao.BookDao;
import ru.otus.library.task05.domain.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }
}
