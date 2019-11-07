package ru.otus.library.task05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.task05.dao.AuthorDao;
import ru.otus.library.task05.dao.AuthorDaoImpl;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.service.AuthorService;

@ShellComponent
public class AppShell {
    AuthorDao authorDao;

    @Autowired
    AuthorService authorService;
    @ShellMethod(value = "login",key = "l")
    public String login(@ShellOption(defaultValue = "mikhail")String login){
        return String.format("Welcome %s", login);
    }
    @ShellMethod(value = "getauthor",key = {"ga","get a"})
    public String getAuthor(@ShellOption(defaultValue = "1") long id){
        return String.format("%s", authorService.getAuthor(id).getLastname());
    }

}
