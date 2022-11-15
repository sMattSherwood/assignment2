package msherwood.assignment2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msherwood.assignment2.model.Authors;

// this is where the author Repository is declared 
@Repository
public interface AuthorRepo extends CrudRepository<Authors,Integer> {

    
}
