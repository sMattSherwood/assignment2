package msherwood.assignment2.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import msherwood.assignment2.model.Authors;
import msherwood.assignment2.model.Books;
import msherwood.assignment2.repositories.AuthorRepo;
import msherwood.assignment2.repositories.BooksRepo;

@Controller
public class MainController {

    BooksRepo booksRepo;
    AuthorRepo authorRepo;

    @Autowired
    public MainController(BooksRepo booksRepo, AuthorRepo authorRepo)
    {
        this.booksRepo = booksRepo;
        this.authorRepo = authorRepo;

// added the authors and their first and last name to the authors table
        Authors georgeOrwell = authorRepo.save(new Authors("George", "Orwell"));
        Authors leoTolstoy = authorRepo.save(new Authors("Leo", "Tolstoy"));
        Authors ernestHemingway = authorRepo.save(new Authors("Ernest", "Hemingway"));
        Authors hermanMelville = authorRepo.save(new Authors("Herman", "Melville"));
        Authors stephenKing = authorRepo.save(new Authors("Stephen", "King"));
        Authors jrrTolkien = authorRepo.save(new Authors("JRR", "Tolkien"));
        Authors roaldDahi = authorRepo.save(new Authors("Roald","Dahi"));
     //   @SuppressWarnings("unused")
// added the books title and price to the books database
        georgeOrwell.getBooksList().add(booksRepo.save(new Books("1984", 24)));
        georgeOrwell.getBooksList().add(booksRepo.save(new Books("Animal Farm", 15)));
        georgeOrwell.getBooksList().add(booksRepo.save(new Books("Burmese Days", 10)));
        leoTolstoy.getBooksList().add(booksRepo.save(new Books("War and Peace", 29)));
        leoTolstoy.getBooksList().add(booksRepo.save(new Books("Childhood", 14)));
        ernestHemingway.getBooksList().add(booksRepo.save(new Books("Death in the Afternoon",35)));
        ernestHemingway.getBooksList().add(booksRepo.save(new Books("Green Hills of Africa", 9)));
        ernestHemingway.getBooksList().add(booksRepo.save(new Books("a Moveable Feast", 44)));
        hermanMelville.getBooksList().add(booksRepo.save(new Books("Moby Dick", 22)));
        stephenKing.getBooksList().add(booksRepo.save(new Books("IT", 19)));
        stephenKing.getBooksList().add(booksRepo.save(new Books("The Green Mile", 50)));
        jrrTolkien.getBooksList().add(booksRepo.save(new Books("The Hobbit", 33)));
        jrrTolkien.getBooksList().add(booksRepo.save(new Books("The Fellowship of the Ring", 35)));
        roaldDahi.getBooksList().add(booksRepo.save(new Books("Fantastic MR.Fox", 12)));
        roaldDahi.getBooksList().add(booksRepo.save(new Books("Boy", 7)));

        //save all of this data
        authorRepo.save(georgeOrwell);
        authorRepo.save(leoTolstoy);
        authorRepo.save(ernestHemingway);
        authorRepo.save(hermanMelville);
        authorRepo.save(stephenKing);
        authorRepo.save(jrrTolkien);
        authorRepo.save(roaldDahi);
    }

    @GetMapping(value="/Authors")
    public String getAuthors()
    {
        return"Authors";

    }

// order the authors by last name
    @GetMapping(value = "/orderLastName")
    public String getOrderLastName(Model model)
    {
        List<Authors> authors = authorRepo.orderByAuthorByLastName();
        model.addAttribute("authors", authors);
        return "/Authors";
    }
// order the authors by first name
    @GetMapping(value = "/orderFirstName")
    public String getOrderFirstName( Model model)
    {
        List<Authors> authors = authorRepo.orderByAuthorByFirstName();
        model.addAttribute("authors", authors);
        return "/Authors";
    }
// this will find an author by first name
    @GetMapping(value = "/findAuthorFirstName")
    public String getAuthorFirstName(@RequestParam String firstName, Model model)
    {
        List<Authors> authors = authorRepo.findByAuthorByFirstName(firstName);
        model.addAttribute("authors", authors);
        return "/Authors";
    }
// this will find an author by last name
    @GetMapping(value = "/findAuthorLastName")
    public String getAuthorLastName(@RequestParam String lastName, Model model)
    {
        List<Authors> authors = authorRepo.findByAuthorByLastName(lastName);
        model.addAttribute("authors", authors);
        return "/Authors";
    }
// find author by letter
    @GetMapping(value ="/findAuthorByLetter")
    public String getAuthorByLetter(@RequestParam String lastNameLetter, Model model)
    {
        List<Authors> authors = authorRepo.findByAuthorByLastNameStartingWith(lastNameLetter);
        model.addAttribute("authors", authors);
        return "/Authors";
    }
// find author by typing a bit of thier name
    @GetMapping(value ="/findAuthorByString")
    public String getAuthorBString(@RequestParam String letterSequence, Model model)
    {
        List<Authors> authors = authorRepo.findByAuthorContaining(letterSequence);
        model.addAttribute("authors", authors);
        return "/Authors";
    }
    @GetMapping(value = "/Books")
    public String getBooks()
    {
        return"/Books";
    }
// this will dispay all books 
    @GetMapping(value = "/displayBooks")
    public String getBooksTitle(Model model)
    {
        List<Books> books = booksRepo.findAllByOrderByBookTitle();
        model.addAttribute("books", books);
        return "/Books";
    }
// this will dispay all books by increasing price
    @GetMapping(value = "/displayBooksByIncreasing")
    public String displayBooksByIncreasing(Model model)
    {
        List<Books> books = booksRepo.findAllByincreasingOrderByAsc();
        model.addAttribute("books", books);
        return "/Books";
    }
// this will display books with two key words
    @GetMapping(value = "/findBooksWithTwoKeywords")
    public String displaybooksUsingTwoKeywords(@RequestParam String keywordOne, @RequestParam String keywordTwo, Model model)
    {
        List<Books> books = booksRepo.findAllKeywordAndSecondKeyword(keywordOne, keywordTwo);
        model.addAttribute("books", books);
        return "/Books";
    }
// this will diplay all that's not the key word
    @GetMapping(value = "/displayBooksWithoutWord")
    public String displayBookWithoutKeyword(@RequestParam String keyword, Model model)
    {
        List<Books> books = booksRepo.findAllBooksWithoutKeyWord(keyword);
        model.addAttribute("books", books);
        return "/Books";
    }
// this will display all with one key word but not the other
    @GetMapping(value = "/displayBooksWithOneKeywod")
    public String dispalyBooksWithOneKeyWord(@RequestParam String keywordOne, @RequestParam String keywordTwo, Model model)
    {
        List<Books> books = booksRepo.findAllBookWithOneKeyWordWithoutKeywordTwo(keywordOne, keywordTwo);
        model.addAttribute("books", books);
        return "/Books";
    }



    
}
