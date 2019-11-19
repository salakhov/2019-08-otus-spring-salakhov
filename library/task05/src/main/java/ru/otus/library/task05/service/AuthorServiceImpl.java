package ru.otus.library.task05.service;

import org.springframework.stereotype.Service;
import ru.otus.library.task05.dao.AuthorDao;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getAuthor(long id){
        return authorDao.getAuthorById(id);
    }

    @Override
    public List<Author> getAllAuthors(){
        return authorDao.getAllAuthors();
    }

    @Override
    public Author getAuthorByLastName(String lastname){
        return authorDao.getAuthorByLastName(lastname);
    }

    @Override
    public List<Author> searchAllAuthorsOfBook(Book book) {
        return authorDao.searchAllAuthorsOfBook(book);
    }
}
