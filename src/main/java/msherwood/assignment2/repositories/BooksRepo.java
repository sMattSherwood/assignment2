package msherwood.assignment2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msherwood.assignment2.model.Books;
// this is where the books repository is declared 
@Repository
public interface BooksRepo extends CrudRepository<Books, Integer> {
    
}
