package ru.otus.task04.service;

import ru.otus.task04.domain.Puzzle;

import java.util.List;

/**
 * Класс сервис для Теста студентов
 */

public interface TestService {
    void read();
    List<Puzzle> getPuzzleList();
    void startTest();

}
