package msherwood.assignment2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msherwood.assignment2.model.Authors;

// this is where the author Repository is declared 
@Repository
public interface AuthorRepo extends CrudRepository<Authors,Integer> {

    List<Authors> orderAuthorByLastName();

    List<Authors> orderAuthorByFirstName();

    List<Authors> searchAuthorByLastName(String lastname);

    List<Authors> searchAuthorByFirstName(String firstName);

    List<Authors> sortAuthorByLastNameLetter(String lastNameLetter);

    List<Authors> sortAuthorByLetterSequence(String letterSequence);

    
}
