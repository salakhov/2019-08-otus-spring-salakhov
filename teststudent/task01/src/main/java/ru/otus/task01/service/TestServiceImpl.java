package ru.otus.task01.service;

import ru.otus.task01.dao.TestDao;
import ru.otus.task01.domain.Answer;
import ru.otus.task01.domain.Puzzle;
import ru.otus.task01.domain.Test;
import java.util.Scanner;

/**
 * Реализация сервиса для взаимодействия с объектом тест.
 */

public class TestServiceImpl implements TestService {
    private TestDao dao;
    private Test test;
    private Scanner scanner;

    public TestServiceImpl(TestDao dao, Test test) {
        this.dao = dao;
        this.test = test;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void read(){
        test = dao.read();
    }

    @Override
    public void printResult(){
        System.out.println("Проверка ответов");
        for(Puzzle pzl:test.getPuzzleList()){
            pzl.printQuestion();
            System.out.println("Ответ: " + pzl.checkAnswer());
        }
    }

    @Override
    public void startInteractiveTest() {
        System.out.println("Имя:");
        String firstName = scanner.nextLine();
        System.out.println(firstName);
        System.out.println("Фамилия:");
        String lastName = scanner.nextLine();
        System.out.println(lastName);
        for(Puzzle pzl:test.getPuzzleList()){
            pzl.printQuestion();
            System.out.println("Варианты ответов:");
            for(Answer ans:pzl.getAnswerList()){
                System.out.println(ans.getAnswer().toString());
            }
            System.out.println("Введите ответ без учета регистра: ");
            Answer ans = new Answer(scanner.nextLine());
            pzl.setUserAnswer(ans);
        }
        printResult();
    }
}
