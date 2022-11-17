package msherwood.assignment2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msherwood.assignment2.model.Books;
// this is where the books repository is declared 
@Repository
public interface BooksRepo extends CrudRepository<Books, Integer> {

    List<Books> orderBooksByTitle(String bookTitle);

    List<Books> orderByincreasingPrice(Integer bookPrice);

    List<Books> findBooksWithKeyWord(String keyWord);

    List<Books> findBooksWithoutKeyWord(String keyWord);

    List<Books> findBookWithOneKeyWord(String keywordList);

    
    
}
