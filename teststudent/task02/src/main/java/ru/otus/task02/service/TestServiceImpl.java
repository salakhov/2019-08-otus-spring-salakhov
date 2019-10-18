package ru.otus.task02.service;

import ru.otus.task02.dao.TestDao;
import ru.otus.task02.domain.Puzzle;
import ru.otus.task02.domain.Test;

import java.util.List;

/**
 * Реализация сервиса для взаимодействия с объектом тест.
 */
public class TestServiceImpl implements TestService {
    private TestDao dao;
    private Test test;
    private UserService userService;

    public TestServiceImpl(TestDao dao,UserService userService) {
        this.dao = dao;
        this.userService = userService;
    }

    @Override
    public void read(){
        test = dao.read();
    }

    @Override
    public List<Puzzle> getPuzzleList() {
        return test.getPuzzleList();
    }

    @Override
    public void startTest() {
        userService.readUserProperties();
        this.read();
        userService.getUserAnswers(getPuzzleList());
        userService.printResult(getPuzzleList());
    }
}