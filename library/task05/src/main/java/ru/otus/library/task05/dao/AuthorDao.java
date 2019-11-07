package ru.otus.library.task05.dao;

import ru.otus.library.task05.domain.Author;

public interface AuthorDao {
    Author getById(long id);
}
