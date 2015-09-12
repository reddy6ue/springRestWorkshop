package life.plank.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

/**
 * Created by Praneeth on 8/25/2015.
 */
@Entity
public class Student extends AbstractEntity {
    @NotNull
    @Max(value = 100)
    private String firstName;
    @NotNull
    @Max(value = 100)
    private String lastName;
    @Max(value = 200)
    private String middleName;

//    @OneToMany
//    private List<Book> issuedBooks = new ArrayList<Book>();
//
//    @ManyToMany
//    private List<Book> reservedBooks = new ArrayList<Book>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
//
//    public List<Book> getIssuedBooks() {
//        return issuedBooks;
//    }
//
//    public void setIssuedBooks(List<Book> issuedBooks) {
//        this.issuedBooks = issuedBooks;
//    }
//
//    public List<Book> getReservedBooks() {
//        return reservedBooks;
//    }
//
//    public void setReservedBooks(List<Book> reservedBooks) {
//        this.reservedBooks = reservedBooks;
//    }

    public static Student createStudentInstance(String fullName) {
        String[] nameParts = fullName.split(" ");
        Student student = new Student();
        if (nameParts != null) {
            switch (nameParts.length) {
                case 1:
                    student.setFirstName(nameParts[0]);
                    student.setLastName("");
                    student.setMiddleName("");
                    break;
                case 2:
                    student.setFirstName(nameParts[0]);
                    student.setLastName(nameParts[1]);
                    student.setMiddleName("");
                    break;
                case 3:
                    student.setFirstName(nameParts[0]);
                    student.setMiddleName(nameParts[2]);
                    student.setLastName(nameParts[1]);
                    break;
            }
        }
        return student;
    }
}