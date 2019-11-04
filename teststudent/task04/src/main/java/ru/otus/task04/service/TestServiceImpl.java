package ru.otus.task04.service;

import org.springframework.stereotype.Service;
import ru.otus.task04.dao.TestDao;
import ru.otus.task04.domain.Puzzle;
import ru.otus.task04.domain.StudentTest;

import java.util.List;

/**
 * Реализация сервиса для взаимодействия с объектом тест.
 */
@Service
public class TestServiceImpl implements TestService {
    private TestDao dao;
    private StudentTest test;
    private UserService userService;
    private boolean testPassed;

    public TestServiceImpl(TestDao dao,UserService userService) {
        this.dao = dao;
        this.userService = userService;
        testPassed=false;
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
        this.read();
        userService.getUserAnswers(getPuzzleList());
        this.testPassed=true;
    }

    @Override
    public boolean isTestPassed(){
        return this.testPassed;
    }

    @Override
    public void resetResults(){
        this.testPassed=false;
    }
}
