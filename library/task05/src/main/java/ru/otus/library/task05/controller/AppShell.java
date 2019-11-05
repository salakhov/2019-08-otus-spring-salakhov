package ru.otus.library.task05.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AppShell {

    @ShellMethod(value = "login",key = "l")
    public String login(@ShellOption(defaultValue = "mikhail")String login){
        return String.format("Welcome %s", login);

    }
}
