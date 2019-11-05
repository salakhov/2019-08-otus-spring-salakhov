package ru.otus.task04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.task04.domain.User;
import ru.otus.task04.service.TestService;
import ru.otus.task04.service.UserService;

@ShellComponent
public class AppShellControllerImpl {
//    @Autowired
//    ConsoleService consoleService;

    @Autowired
    UserService userService;

    @Autowired
    TestService testService;

    @ShellMethod(value = "Authentication [firstname] [lastname]. mikhail salakhov by default",key = { "l", "login" })
    public String login(@ShellOption(defaultValue = "mikhail") String firstName,
                      @ShellOption(defaultValue = "salakhov") String lastName) {
       userService.setUserName(firstName);
       userService.setUserSecondName(lastName);
       return String.format("Welcome: %s %s",userService.getUserName(),userService.getUserSecondName());
    }

    @ShellMethod(value = "Запуск теста",key={"r","run","start"})
    @ShellMethodAvailability(value = "isRunAvailable")
    public void run(){
        testService.startTest();
    }

    @ShellMethod(value = "Посмотреть результат", key={"s","show","print"})
    @ShellMethodAvailability(value="isCheckResultAvailable")
    public void showResult(){
        userService.printResult(testService.getPuzzleList());
    }

    @ShellMethod(value = "Выход",key={"logout"})
    public void logout(){
        System.out.println(String.format("Buy: %s %s",userService.getUserName(),userService.getUserSecondName()));
        userService.setUserSecondName(null);
        userService.setUserName(null);
        testService.resetResults();
    }

    private Availability isRunAvailable() {
        return userService.getUserName() == null? Availability.unavailable("login first"): Availability.available();
    }

    private Availability isCheckResultAvailable() {
        return testService.isTestPassed() ? Availability.available():Availability.unavailable("pass the test first");
    }

}
