package ru.otus.task03.service;

import ru.otus.task03.domain.Puzzle;
import ru.otus.task03.domain.User;

import java.util.List;

public interface UserService {
    User readUserProperties();
    void printResult(List<Puzzle> puzzleList);
    void getUserAnswers(List<Puzzle> puzzleList);
}
