package msherwood.assignment2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// this is where the Authors table is created
@Table(name="AUTHORS")
@NoArgsConstructor
public class Authors {
// this is the constructor that will allow the object to pass data to using the columns
    public Authors(String firstName, String lastName) {
        this.authorsId=0;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
    @Id     // this is where the ID of the table is declared
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Authors_ID")
    private Integer authorsId;
// First name column is declared
    @Column(name="FIRST_NAME")
    private String firstName;
// last name column is declared
    @Column(name="LAST_NAME")
    private String lastName;

// this will declare a one to many relationship with books where one authors can have many books
    @OneToMany
    @JoinColumn(name="AUTHOR_ID")
// this array list will allow the many books be associated with an author
    List<Books> booksList;



    


    
}
