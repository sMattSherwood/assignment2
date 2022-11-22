package msherwood.assignment2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msherwood.assignment2.model.Authors;

// this is where the author Repository is declared 
@Repository
public interface AuthorRepo extends CrudRepository<Authors,Integer> {
// this will create a query to order by last name
    List<Authors> orderByAuthorByLastName();
// this will create a query where they will order by first name
    List<Authors> orderByAuthorByFirstName();
// this will create a query where you will search for a specific first name
    List<Authors> findByAuthorByLastName(String lastname);
// this will create a query where you will search for a specific last name
    List<Authors> findByAuthorByFirstName(String firstName);
// this will create a query where you need to type the first letter and it will show list of names
    List<Authors> findByAuthorByLastNameStartingWith(String lastNameLetter);
// this will create a query where you type a bit of a last name or phrase and it will display a name
    List<Authors> findByAuthorContaining(String letterSequence);
}
