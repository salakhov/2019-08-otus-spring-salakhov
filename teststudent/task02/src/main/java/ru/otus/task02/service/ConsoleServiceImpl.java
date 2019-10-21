package ru.otus.task02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.task02.domain.Answer;
import ru.otus.task02.domain.Puzzle;

import java.util.List;
import java.util.Scanner;
@Service
public class ConsoleServiceImpl implements ConsoleService {
    private Scanner scanner;
    private LocaleService localeService;

    @Autowired
    MessageSource messageSource;

    public ConsoleServiceImpl(LocaleService locale) {
        this.scanner = new Scanner(System.in);
        this.localeService = locale;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public void printUserNameRequestMessage(){
        System.out.println(localeService.getMessage("user.name"));
    }

    @Override
    public void printUserSecondNameRequestMessage(){
        System.out.println(localeService.getMessage("user.lastname"));
    }

    @Override
    public void printAnswerVariantMessage(){
        System.out.println(localeService.getMessage("app.iface.variants"));
    }

    @Override
    public void printChooseVariantMessage(){
        System.out.println(localeService.getMessage("app.iface.typeanswer"));
    }

    @Override
    public void printQuestion(Puzzle pzl){
        System.out.println(pzl.getQuestion().getText());
    }

    public void printAnswerVariants(Puzzle pzl){
        for(Answer ans:pzl.getAnswerList()){
            System.out.println(ans.getText());
        }
    }

    public void printPrintResultMessage(){
        System.out.println(localeService.getMessage("app.iface.printresult"));
    }

    @Override
    public void printTestResult(List<Puzzle> puzzleList){
        for(Puzzle pzl:puzzleList){
            System.out.println(pzl.getQuestion().getText());
            System.out.println(pzl.checkAnswer());
        }
    }

}
