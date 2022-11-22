package msherwood.assignment2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msherwood.assignment2.model.Books;
// this is where the books repository is declared 
@Repository
public interface BooksRepo extends CrudRepository<Books, Integer> {
// this will create a query where it will order all by book title
    List<Books> findAllByOrderByBookTitle();
// this will create a query where it will order by increasing price
    List<Books> findAllByincreasingPriceOrderByAsc();
// this will create a query where it will dispay all books with the two key words
    List<Books> findAllKeywordAndSecondKeyword(String keyWord, String SecondkeyWord);
// this will create a query where it will display books without the keyword
    List<Books> findAllBooksWithoutKeyWord(String keyWord);
// this will create a query where it will display the first keyword but not the second one
    List<Books> findAllBookWithOneKeyWordWithoutKeywordTwo(String keyword, String KeywordTwo);


    
}
