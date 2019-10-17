package ru.otus.task02.service;

import ru.otus.task02.domain.Puzzle;

import java.util.List;

public interface ConsoleService {
    String readLine();
    void printUserNameRequestMessage();
    void printUserSecondNameRequestMessage();
    void printAnswerVariantMessage();
    void printChooseVariantMessage();
    void printQuestion(Puzzle pzl);
    void printAnswerVariants(Puzzle pzl);
    void printPrintResultMessage();
    void printTestResult(List<Puzzle> puzzleList);
}
