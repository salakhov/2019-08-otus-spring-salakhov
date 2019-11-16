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
import ru.otus.library.task05.domain.Genre;
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

    @ShellMethod(value = "getAuthorLastNameById id",key = {"gabi","get author by id"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public String getAuthorLastNameById(@ShellOption(defaultValue = "1") long id){
        return String.format("%s", authorService.getAuthor(id).getLastName());
    }

    @ShellMethod(value = "getAllAuthors",key = {"gaa","get all author"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public List<Author> getAllAuthors(){
        List<Author> authorList =authorService.getAllAuthors();
        authorList.forEach(n->System.out.println(n.getLastName()+ " "+ n.getFirstName()+" " + n.getSecondName()));
        return authorList;
    }

    @ShellMethod(value = "getauthors",key = {"gabl","get author by lastname"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public Author getAuthorByLastName(String lastname){
        Author author = authorService.getAuthorByLastName(lastname);
        System.out.println(author.getLastName()+ " "+
                author.getFirstName()+" " + author.getSecondName());
        return author;
    }

    @ShellMethod(value = "gab",key = {"gab","get all books"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public List<Book> getAllBooks(){
        List<Book> bookList = bookService.getAllBooks();
        bookList.forEach(n->System.out.println(n.getTitle()));
        return bookList;
    }

    @ShellMethod(value = "gag",key = {"gag","gat all genres"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public List<Genre> getAllGenres(){
        List<Genre> genreList;
        genreList = genreService.getAllGenres();
        genreList.forEach(n->System.out.println(n.getName()));
        return genreList;
    }

    @ShellMethod(value = "searchAllAuthorsOfBook",key = {"sab","search authors by book"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public List <Author> searchAllAuthorsOfBook(String bookTitlle){
        List<Book> bookList = bookService.getBooksByTitle(bookTitlle);
        if(bookList.isEmpty())
            System.out.println("Книга с таким наизванием не найдена");
        List<Author> authorList = catalogService.searchAllAuthorsOfBook(bookList.get(0));
        authorList.forEach((n)->System.out.println(n.getLastName() + " " + n.getFirstName()));
        return authorList;
    }

    @ShellMethod(value = "searchAllBooksOfAuthor",key = {"sba","search books by author"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public List<Book> searchAllBooksOfAuthor(String lastname){
        Author author = authorService.getAuthorByLastName(lastname);
        List<Book> bookList = catalogService.searchAllBooksOfAuthor(author);
        bookList.forEach((n)->System.out.println(n.getTitle()));
        return  bookList;
    }

    private Availability isLoggedIn(){
        return loggedIn ? Availability.available():Availability.unavailable("login first");
    }
}
