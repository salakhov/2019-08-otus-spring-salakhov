package ru.otus.task02.service;

import ru.otus.task02.domain.Puzzle;

import java.util.List;

/**
 * Класс сервис для Теста студентов
 */

public interface TestService {
    void read();
    List<Puzzle> getPuzzleList();
}
