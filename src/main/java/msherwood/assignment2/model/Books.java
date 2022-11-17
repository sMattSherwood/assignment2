package msherwood.assignment2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// this is where the books table is declared 
@Table(name="BOOKS")
@NoArgsConstructor
public class Books {

// constructor to give the items values 
    public Books(String bookTitle, Integer price) {
        this.bookTitle = bookTitle;
        this.price = price;
    }   
 // this indicates the ID of this table   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOK_ID")
    private Integer bookId;
// book title column
    @Column(name="BOOK_TITLE")
    private String bookTitle;
// book year column
    @Column(name="BOOK_YEAR")
    private Integer price;    
}
