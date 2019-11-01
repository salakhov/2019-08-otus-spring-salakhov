package ru.otus.task04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.task04.domain.User;

@ShellComponent
public class AppShellServiceImpl {
    @Autowired
    ConsoleService consoleService;

    UserService userService;

    @ShellMethod(value = "login",key = "l")
    public void login(@ShellOption String user) {
       userService.readUserProperties();
    }
}
