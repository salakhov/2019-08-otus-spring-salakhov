package ru.otus.task01.service;

/**
 * Реализация сервиса для взаимодействия с пользователем.
 */

public class UserServiceImpl implements UserService {
    private TestService testService;

    public UserServiceImpl(TestService testService) {
        this.testService = testService;
    }

    @Override
    public void runTest(){
        testService.read();
        testService.startInteractiveTest();
    }
}
