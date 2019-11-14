package ru.otus.library.task05.service;

import org.springframework.stereotype.Service;
import ru.otus.library.task05.dao.CatalogDao;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.domain.Catalog;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService{
    private CatalogDao catalogDao;

    public CatalogServiceImpl(CatalogDao catalogDao) {
        this.catalogDao = catalogDao;
    }

    @Override
    public List<Author> searchAllAuthorsOfBook(Book book){
        return catalogDao.searchAllAuthorsOfBook(book);
    }

    @Override
    public List<Book> searchAllBooksOfAuthor(Author book){
        return null;
    }
}
