import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import msherwood.assignment2.model.Authors;
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
    }



    
}
