package ru.otus.task01.service;

import ru.otus.task01.domain.Answer;
import ru.otus.task01.domain.Puzzle;
import ru.otus.task01.domain.User;


/**
 * Реализация сервиса для взаимодействия с пользователем.
 */

public class UserServiceImpl implements UserService {
    private TestService testService;
    private ConsoleService consoleService;
    private User user;

    public UserServiceImpl(TestService testService, ConsoleService consoleService) {
        this.testService = testService;
        this.consoleService = consoleService;
        user = new User();
    }

    @Override
    public void TestUser(){
        this.readUserProperties();
        testService.read();
        this.getUserAnswers();
        testService.printResult();
    }
    @Override
    public User readUserProperties(){
        System.out.println("Имя:");
        user.setFirstName(consoleService.readLine());
        System.out.println("Фамилия:");
        user.setSecondName(consoleService.readLine());
        return user;
    }

    @Override
    public void getUserAnswers() {
        for(Puzzle pzl:testService.getPuzzleList()){
            System.out.println(pzl.getQuestion().toString());
            System.out.println("Варианты ответов:");
            for(Answer ans:pzl.getAnswerList()){
                System.out.println(ans.getAnswer().toString());
            }
            System.out.println("Введите ответ без учета регистра: ");
            Answer ans = new Answer(consoleService.readLine());
            pzl.setUserAnswer(ans);
        }
    }
}
