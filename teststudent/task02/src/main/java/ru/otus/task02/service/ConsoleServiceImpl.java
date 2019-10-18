package ru.otus.task02.service;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import ru.otus.task02.domain.Answer;
import ru.otus.task02.domain.Puzzle;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
@Service
public class ConsoleServiceImpl implements ConsoleService {
    private Scanner scanner;
    private LocaleService locale;
    MessageSource messageSource;

    public ConsoleServiceImpl(LocaleService locale) {
        this.scanner = new Scanner(System.in);
        this.locale = locale;
        this.messageSource = initMessageSource();
    }

    private MessageSource initMessageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("i18n");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public void printUserNameRequestMessage(){
        System.out.println(messageSource.getMessage("user.name",new String[] {},locale.getLocale()));
    }

    @Override
    public void printUserSecondNameRequestMessage(){
        System.out.println(messageSource.getMessage("user.lastname", new String[] {}, locale.getLocale()));
    }

    @Override
    public void printAnswerVariantMessage(){
        System.out.println(messageSource.getMessage("app.iface.variants", new String[] {}, locale.getLocale()));
    }

    @Override
    public void printChooseVariantMessage(){
        System.out.println(messageSource.getMessage("app.iface.typeanswer", new String[] {}, locale.getLocale()));
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
        System.out.println(messageSource.getMessage("app.iface.printresult", new String[] {}, locale.getLocale()));
    }

    @Override
    public void printTestResult(List<Puzzle> puzzleList){
        for(Puzzle pzl:puzzleList){
            System.out.println(pzl.getQuestion().getText());
            System.out.println(pzl.checkAnswer());
        }
    }

}
