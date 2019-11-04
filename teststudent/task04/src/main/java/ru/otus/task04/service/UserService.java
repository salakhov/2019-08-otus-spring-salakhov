package ru.otus.task04.service;

import ru.otus.task04.domain.Puzzle;
import ru.otus.task04.domain.User;

import java.util.List;

public interface UserService {
    User readUserProperties();
    void printResult(List<Puzzle> puzzleList);
    void getUserAnswers(List<Puzzle> puzzleList);
    void setUserName(String username);
    String getUserName();
    String getUserSecondName();
    void setUserSecondName(String userSecondName);
}
