package ru.otus.library.task05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.task05.dao.AuthorDao;
import ru.otus.library.task05.dao.AuthorDaoImpl;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.service.AuthorService;
import ru.otus.library.task05.service.BookService;
import ru.otus.library.task05.service.CatalogService;
import ru.otus.library.task05.service.GenreService;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import java.util.List;

@ShellComponent
public class AppShell {

    private AuthorService authorService;
    private BookService bookService;
    private GenreService genreService;
    private CatalogService catalogService;
    private boolean loggedIn;

    public AppShell(AuthorService authorService, BookService bookService, GenreService genreService, CatalogService catalogService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.genreService = genreService;
        this.catalogService = catalogService;
        this.loggedIn = false;
    }

    @ShellMethod(value = "login",key = "l")
    public String login(@ShellOption(defaultValue = "user")String login){
        loggedIn = true;
        return String.format("Welcome: %s", login);
    }
    @ShellMethod(value = "logout",key = "logout")
    @ShellMethodAvailability(value = "isLoggedIn")
    public String logout(){
        loggedIn = false;
        return String.format("Good Buy");
    }

    @ShellMethod(value = "getauthor",key = {"ga","get author"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public String getAuthor(@ShellOption(defaultValue = "1") long id){
        return String.format("%s", authorService.getAuthor(id).getLastName());
    }

    @ShellMethod(value = "getauthors",key = {"gaa","get all author"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public void getAllAuthor(@ShellOption(defaultValue = "1") long id){
        authorService.getAllAuthors().forEach(n->System.out.println(n.getLastName()+ " "+
                n.getFirstName()+" " + n.getSecondName()));
    }

    @ShellMethod(value = "getauthors",key = {"galn","get all author lastname"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public void getAllAuthorByLastname(String lastname){
        Author author = authorService.getAuthorByLastName(lastname);
        System.out.println(author.getLastName()+ " "+
                author.getFirstName()+" " + author.getSecondName());
    }

    @ShellMethod(value = "gab",key = {"gab","gat all books"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public void getAllBooks(){
        bookService.getAllBooks().forEach(n->System.out.println(n.getTitle()));
    }

    @ShellMethod(value = "gag",key = {"gag","gat all genres"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public void getAllGenres(){
        genreService.getAllGenres().forEach(n->System.out.println(n.getName()));
    }

    @ShellMethod(value = "sabb",key = {"sabb","search author of book"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public void searchAllAuthorsOfBook(String bookTitlle){
        List<Book> bookList = bookService.getBookByTitle(bookTitlle);
        if(bookList.isEmpty())
            System.out.println("Книга с таким наизванием не найдена");
        List<Author> authorList = catalogService.searchAllAuthorsOfBook(bookList.get(0));
        authorList.forEach((n)->System.out.println(n.getLastName() + " " + n.getFirstName()));
    }


    private Availability isLoggedIn(){
        return loggedIn ? Availability.available():Availability.unavailable("login first");
    }
}
