package ru.otus.task04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.task04.domain.Answer;
import ru.otus.task04.domain.Puzzle;
import ru.otus.task04.domain.User;

import java.util.List;
import java.util.Locale;


/**
 * Реализация сервиса для взаимодействия с пользователем.
 */
@Service
public class UserServiceImpl implements UserService {
    private ConsoleService consoleService;
    private User user;

    @Autowired
    public UserServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
        user = new User();
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
    public void getUserAnswers(List<Puzzle> puzzleList) {
        for(Puzzle pzl:puzzleList){
            consoleService.printQuestion(pzl);
            consoleService.printAnswerVariantMessage();
            consoleService.printAnswerVariants(pzl);
            consoleService.printChooseVariantMessage();
            Answer ans = new Answer(consoleService.readLine());
            pzl.setUserAnswer(ans);
        }
    }
    @Override
    public void printResult(List<Puzzle> puzzleList){
        consoleService.printPrintResultMessage();
        consoleService.printTestResult(puzzleList);
    }


}
