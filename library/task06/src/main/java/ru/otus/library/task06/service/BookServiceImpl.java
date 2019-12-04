package ru.otus.library.task06.service;

import org.springframework.stereotype.Service;
import ru.otus.library.task06.dao.AuthorDao;
import ru.otus.library.task06.dao.BookDao;
import ru.otus.library.task06.domain.Author;
import ru.otus.library.task06.domain.Book;

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
    public List<Book> getBooksByTitle(String title) {
        return bookDao.getBooksByTitle(title);
    }

    @Override
    public List<Book> searchAllBooksOfAuthor(Author author){
        return bookDao.searchAllBooksOfAuthor(author);
    }
}
