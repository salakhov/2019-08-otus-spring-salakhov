package ru.otus.task02.service;

import org.springframework.stereotype.Service;
import ru.otus.task02.dao.TestDao;
import ru.otus.task02.domain.Puzzle;
import ru.otus.task02.domain.Test;

import java.util.List;

/**
 * Реализация сервиса для взаимодействия с объектом тест.
 */
@Service
public class TestServiceImpl implements TestService {
    private TestDao dao;
    private Test test;

    public TestServiceImpl(TestDao dao) {
        this.dao = dao;
    }

    @Override
    public void read(){
        test = dao.read();
    }

    @Override
    public List<Puzzle> getPuzzleList() {
        return test.getPuzzleList();
    }
}
