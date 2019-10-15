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


    public TestServiceImpl(TestDao dao, Test test) {
        this.dao = dao;
        this.test = test;

    }

    @Override
    public void read(){
        test = dao.read();
    }

    @Override
    public void printResult(){
        System.out.println("Печать результата");
        for(Puzzle pzl:getPuzzleList()){
            System.out.println(pzl.getQuestion().toString());
            System.out.println("Ответ: " + pzl.checkAnswer());
        }
    }

    @Override
    public List<Puzzle> getPuzzleList() {
        return test.getPuzzleList();
    }
}
