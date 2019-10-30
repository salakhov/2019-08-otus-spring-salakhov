package ru.otus.task03.service;

import ru.otus.task03.domain.Puzzle;

import java.util.List;

/**
 * Класс сервис для Теста студентов
 */

public interface TestService {
    void read();
    List<Puzzle> getPuzzleList();
    void startTest();

}
