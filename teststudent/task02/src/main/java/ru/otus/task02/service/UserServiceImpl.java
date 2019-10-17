package ru.otus.task02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.task02.domain.Answer;
import ru.otus.task02.domain.Puzzle;
import ru.otus.task02.domain.User;

import java.util.Locale;


/**
 * Реализация сервиса для взаимодействия с пользователем.
 */
@Service
public class UserServiceImpl implements UserService {
    private TestService testService;
    private ConsoleService consoleService;
    private User user;

    @Autowired
    public UserServiceImpl(TestService testService, ConsoleService consoleService) {
        this.testService = testService;
        this.consoleService = consoleService;
        user = new User();
    }

    @Override
    public void testUser(){
        this.readUserProperties();
        testService.read();
        this.getUserAnswers();
        consoleService.printPrintResultMessage();
        consoleService.printTestResult(testService.getPuzzleList());
    }
    @Override
    public User readUserProperties(){
        consoleService.printUserNameRequestMessage();
        user.setFirstName(consoleService.readLine());
        consoleService.printUserSecondNameRequestMessage();
        user.setSecondName(consoleService.readLine());
        return user;
    }

    @Override
    public void getUserAnswers() {
        for(Puzzle pzl:testService.getPuzzleList()){
            consoleService.printQuestion(pzl);
            consoleService.printAnswerVariantMessage();
            consoleService.printAnswerVariants(pzl);
            consoleService.printChooseVariantMessage();
            Answer ans = new Answer(consoleService.readLine());
            pzl.setUserAnswer(ans);
        }
    }


}
