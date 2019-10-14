package ru.otus.task01.service;

import ru.otus.task01.domain.Answer;
import ru.otus.task01.domain.Puzzle;
import ru.otus.task01.domain.User;

import java.util.Scanner;

/**
 * Реализация сервиса для взаимодействия с пользователем.
 */

public class UserServiceImpl implements UserService {
    private TestService testService;
    private Scanner scanner;
    private User user;

    public UserServiceImpl(TestService testService) {
        this.testService = testService;
        this.scanner = new Scanner(System.in);
        user = new User();
    }

    @Override
    public void runTest(){
        testService.read();
        readUserProperties();

        for(Puzzle pzl:testService.getPuzzleList()){
            System.out.println(pzl.getQuestion().toString());
            System.out.println("Варианты ответов:");
            for(Answer ans:pzl.getAnswerList()){
                System.out.println(ans.getAnswer().toString());
            }
            System.out.println("Введите ответ без учета регистра: ");
            Answer ans = new Answer(scanner.nextLine());
            pzl.setUserAnswer(ans);
        }
        testService.printResult();
    }

    public void readUserProperties(){
        System.out.println("Имя:");
        user.setFirstName(scanner.nextLine());
        System.out.println("Фамилия:");
        user.setSecondName(scanner.nextLine());
    }


}
