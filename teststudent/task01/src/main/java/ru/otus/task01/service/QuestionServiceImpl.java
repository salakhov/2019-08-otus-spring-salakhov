package ru.otus.task01.service;

import ru.otus.task01.dao.QuestionDao;
import ru.otus.task01.domain.Question;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getQuestion(){
        Question question = dao.readQuestion();
        return question;
    }

}
