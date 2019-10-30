package ru.otus.task01.service;

import ru.otus.task01.domain.Puzzle;

import java.util.List;

/**
 * Класс сервис для Теста студентов
 */

public interface TestService {
    void read();
    void printResult();
    List<Puzzle> getPuzzleList();
}
