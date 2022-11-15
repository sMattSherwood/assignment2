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



    


    
}
