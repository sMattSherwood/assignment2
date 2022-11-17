import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    }



    
}
