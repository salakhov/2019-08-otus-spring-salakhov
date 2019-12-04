package ru.otus.library.task06.dao;

import ru.otus.library.task06.domain.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAllGenres();
    Genre getGenreById(long id);
}
