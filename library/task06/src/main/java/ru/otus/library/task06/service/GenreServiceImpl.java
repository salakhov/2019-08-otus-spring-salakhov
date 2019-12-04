package ru.otus.library.task06.service;

import org.springframework.stereotype.Service;
import ru.otus.library.task06.dao.GenreDao;
import ru.otus.library.task06.domain.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAllGenres();
    }
}
