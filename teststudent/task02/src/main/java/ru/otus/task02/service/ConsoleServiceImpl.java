package ru.otus.task02.service;

import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {
    private Scanner scanner;

    public ConsoleServiceImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
