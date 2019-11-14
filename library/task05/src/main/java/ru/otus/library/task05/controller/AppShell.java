package ru.otus.library.task05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.task05.dao.AuthorDao;
import ru.otus.library.task05.dao.AuthorDaoImpl;
import ru.otus.library.task05.domain.Author;
import ru.otus.library.task05.domain.Book;
import ru.otus.library.task05.service.AuthorService;
import ru.otus.library.task05.service.BookService;
import ru.otus.library.task05.service.CatalogService;
import ru.otus.library.task05.service.GenreService;

import java.util.List;

@ShellComponent
public class AppShell {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @Autowired
    GenreService genreService;

    @Autowired
    CatalogService catalogService;

    @ShellMethod(value = "login",key = "l")
    public String login(@ShellOption(defaultValue = "mikhail")String login){
        return String.format("Welcome %s", login);
    }
    @ShellMethod(value = "getauthor",key = {"ga","get author"})
    public String getAuthor(@ShellOption(defaultValue = "1") long id){
        return String.format("%s", authorService.getAuthor(id).getLastName());
    }

    @ShellMethod(value = "getauthors",key = {"gaa","get all author"})
    public void getAllAuthor(@ShellOption(defaultValue = "1") long id){
        authorService.getAllAuthors().forEach(n->System.out.println(n.getLastName()+ " "+
                n.getFirstName()+" " + n.getSecondName()));
//        return String.format("%s", ;);
    }

    @ShellMethod(value = "getauthors",key = {"galn","get all author lastname"})
    public void getAllAuthorByLastname(String lastname){
        Author author = authorService.getAuthorByLastName(lastname);
        System.out.println(author.getLastName()+ " "+
                author.getFirstName()+" " + author.getSecondName());
    }

    @ShellMethod(value = "gab",key = {"gab","gat all books"})
    public void getAllBooks(){
        bookService.getAllBooks().forEach(n->System.out.println(n.getTitle()));
    }

    @ShellMethod(value = "gag",key = {"gag","gat all genres"})
    public void getAllGenres(){
        genreService.getAllGenres().forEach(n->System.out.println(n.getName()));
    }

    @ShellMethod(value = "sabb",key = {"sabb","search author of book"})
    public void searchAllAuthorsOfBook(String bookTitlle){
        List<Book> bookList = bookService.getBookByTitle(bookTitlle);
        if(bookList.isEmpty())
            System.out.println("Книга с таким наизванием не найдена");
        List<Author> authorList = catalogService.searchAllAuthorsOfBook(bookList.get(0));
        authorList.forEach((n)->System.out.println(n.getLastName() + " " + n.getFirstName()));
    }
}
