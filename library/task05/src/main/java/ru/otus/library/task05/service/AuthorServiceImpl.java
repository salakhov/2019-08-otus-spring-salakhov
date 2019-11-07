package ru.otus.library.task05.service;

import org.springframework.stereotype.Service;
import ru.otus.library.task05.dao.AuthorDao;
import ru.otus.library.task05.domain.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getAuthor(long id){
        return authorDao.getById(id);
    }
}